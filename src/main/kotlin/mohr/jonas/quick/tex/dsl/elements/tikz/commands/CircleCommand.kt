package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.*
import java.awt.geom.Rectangle2D

class CircleCommand(
    var position: Position,
    var radius: Float,
    var fc: Colors?,
    var lc: Colors,
    var lt: LineThickness,
    parent: DslElement?
) : TikzCommand(parent) {

    override fun getBounds(): Rectangle2D.Float = Rectangle2D.Float(
        position.first - radius, position.second - radius, 2 * radius, 2 * radius
    )

    override fun toString(): String {
        val position = position.fmt()
        val radius = radius.singleDec()
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(fc!!) else null
        return "\\draw[draw=$lineColor, $lineThickness${
            ifNull(
                fillColor, emptyString(), ", fill=$fillColor"
            )
        }] $position circle [radius=$radius];"
    }
}

fun Tikz.c(
    position: Position,
    radius: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
) = circle(position, radius.toFloat(), fc, lc, lt)

fun Tikz.circle(
    position: Position,
    radius: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): CircleCommand {
    val command = CircleCommand(position, radius.toFloat(), fc, lc, lt, this)
    addChild(command)
    return command
}

fun Translation.circle(
    radius: Number, fc: Colors? = null, lc: Colors = Colors.BLACK, lt: LineThickness = LineThickness.SEMITHICK
): CircleCommand {
    val command = CircleCommand(
        reference.getBounds().center().add(translationX, translationY),
        radius.toFloat(),
        fc,
        lc,
        lt,
        reference.parent
    )
    (reference.parent as ParentElement).addChild(command)
    return command
}

fun Translation.c(
    radius: Number, fc: Colors? = null, lc: Colors = Colors.BLACK, lt: LineThickness = LineThickness.SEMITHICK
) = circle(radius, fc, lc, lt)