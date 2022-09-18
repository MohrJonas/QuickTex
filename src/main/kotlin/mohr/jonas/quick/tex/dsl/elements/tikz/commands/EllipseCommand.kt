package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.*
import java.awt.geom.Rectangle2D

class EllipseCommand(
    var position: Position,
    var radiusX: Float,
    var radiusY: Float,
    var fc: Colors?,
    var lc: Colors,
    var lt: LineThickness,
    parent: DslElement?
) : TikzCommand(parent) {
    override fun getBounds() = Rectangle2D.Float(
        position.first - radiusX, position.second - radiusY, 2 * radiusX, 2 * radiusY
    )

    override fun toString(): String {
        val position = position.fmt()
        val radiusX = radiusX.singleDec()
        val radiusY = radiusY.singleDec()
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(fc!!) else null
        return "\\draw[draw=$lineColor, $lineThickness${
            ifNull(
                fillColor, emptyString(), ", fill=$fillColor"
            )
        }] $position ellipse ($radiusX and $radiusY);"
    }
}

fun Tikz.ellipse(
    position: Position,
    radiusX: Float,
    radiusY: Float,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): EllipseCommand {
    val command = EllipseCommand(position, radiusX, radiusY, fc, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.e(
    position: Position,
    radiusX: Number,
    radiusY: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
) = ellipse(position, radiusX.toFloat(), radiusY.toFloat(), fc, lc, lt)

fun Translation.ellipse(
    radiusX: Number,
    radiusY: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): EllipseCommand {
    val command = EllipseCommand(
        reference.getBounds().center().add(translationX, translationY),
        radiusX.toFloat(),
        radiusY.toFloat(),
        fc,
        lc,
        lt,
        reference.parent
    )
    (reference.parent as ParentElement).addChild(command)
    return command
}

fun Translation.e(
    radiusX: Number,
    radiusY: Number,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
) = ellipse(radiusX, radiusY, fc, lc, lt)