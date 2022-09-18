package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.add
import java.awt.geom.Rectangle2D

class ArrowCommand(
    var start: Position,
    var end: Position,
    var type: ArrowType,
    var lc: Colors,
    var lt: LineThickness,
    parent: DslElement?
) : TikzCommand(parent) {

    override fun getBounds() =
        Rectangle2D.Float(start.first, start.second, end.first - start.first, end.second - start.second)

    override fun toString(): String {
        val startPosition = start.fmt()
        val endPosition = end.fmt()
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val arrow = ArrowType.asTikzArrow(type)
        return "\\draw[draw=$lineColor, $lineThickness, $arrow] $startPosition -- $endPosition;"
    }
}

fun Tikz.arrow(
    start: Position,
    end: Position,
    type: ArrowType = ArrowType.RIGHT,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
): ArrowCommand {
    val command = ArrowCommand(start, end, type, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.a(
    start: Position,
    end: Position,
    type: ArrowType = ArrowType.RIGHT,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
) = arrow(start, end, type, lc, lt)

fun Translation.arrow(
    start: Position,
    end: Position,
    type: ArrowType = ArrowType.RIGHT,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
): ArrowCommand {
    val command =
        ArrowCommand(
            start.add(translationX, translationY),
            end.add(translationX, translationY),
            type,
            lc,
            lt,
            reference.parent
        )
    (reference.parent as ParentElement).addChild(command)
    return command
}

fun Translation.a(
    start: Position,
    end: Position,
    type: ArrowType = ArrowType.RIGHT,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
) = arrow(start, end, type, lc, lt)