package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.ifNull
import mohr.jonas.quick.tex.util.singleDec

class EllipseCommand(
    private val position: Position,
    private val radiusX: Float,
    private val radiusY: Float,
    private val fc: Colors?,
    private val lc: Colors,
    private val lt: LineThickness
) : ChildElement {
    override fun toLatexString(): String {
        val position = position.fmt()
        val radiusX = radiusX.singleDec()
        val radiusY = radiusY.singleDec()
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(lc) else null
        return "\\draw[draw=$lineColor, $lineThickness${ifNull(fillColor, emptyString(), ", fill=$fillColor")}] $position circle [x radius=$radiusX, y radius=$radiusY];"
    }
}