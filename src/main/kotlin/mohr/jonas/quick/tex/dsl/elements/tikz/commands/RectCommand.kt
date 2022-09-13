package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.ifNull

class RectCommand(
    private val position1: Position,
    private val position2: Position,
    private val fc: Colors?,
    private val lc: Colors,
    private val lt: LineThickness
) : ChildElement {

    override fun toLatexString(): String {
        val position1 = position1.fmt()
        val position2 = position2.fmt()
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(lc) else null
        return "\\draw[draw=$lineColor, $lineThickness${ifNull(fillColor, emptyString(), ", fill=$fillColor")}] $position1 rectangle $position2;"
    }
}