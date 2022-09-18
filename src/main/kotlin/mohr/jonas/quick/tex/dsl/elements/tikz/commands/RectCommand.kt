package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.add
import mohr.jonas.quick.tex.util.center
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.ifNull
import java.awt.geom.Rectangle2D

class RectCommand(
    var position: Position,
    var width: Float,
    var height: Float,
    var fc: Colors?,
    var lc: Colors,
    var lt: LineThickness,
    parent: DslElement?
) : TikzCommand(parent) {
    override fun getBounds() = Rectangle2D.Float(
        position.first - width / 2, position.second - height / 2, width, height
    )

    override fun toString(): String {
        val position1 = Position(position.first - width / 2, position.second - height / 2)
        val position2 = Position(position.first + width / 2, position.second + height / 2)
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(fc!!) else null
        return "\\draw[draw=$lineColor, $lineThickness${
            ifNull(
                fillColor, emptyString(), ", fill=$fillColor"
            )
        }] $position1 rectangle $position2;"
    }
}

fun Tikz.rect(
    position: Position,
    width: Number,
    height: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): RectCommand {
    val command = RectCommand(position, width.toFloat(), height.toFloat(), fc, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.r(
    position: Position,
    width: Number,
    height: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
) = rect(position, width, height, fc, lc, lt)

fun Translation.rect(
    width: Number,
    height: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): RectCommand {
    val command = RectCommand(
        reference.getBounds().center().add(translationX, translationY),
        width.toFloat(),
        height.toFloat(),
        fc,
        lc,
        lt,
        reference.parent
    )
    (reference.parent as ParentElement).addChild(command)
    return command
}

fun Translation.r(
    width: Number,
    height: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
) = rect(width, height, fc, lc, lt)