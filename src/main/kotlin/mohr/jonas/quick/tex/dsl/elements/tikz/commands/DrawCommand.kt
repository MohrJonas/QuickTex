package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors
import mohr.jonas.quick.tex.dsl.elements.tikz.LineThickness
import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import mohr.jonas.quick.tex.dsl.elements.tikz.fmt
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.ifNull
import org.apache.commons.lang3.StringUtils

class DrawCommand(
    private vararg val positions: Position,
    private val fc: Colors?,
    private val lc: Colors,
    private val lt: LineThickness,
    private val cycle: Boolean
) : ChildElement {

    override fun toLatexString(): String {
        val positions = StringUtils.joinWith(" -- ", *positions.map { it.fmt() }.toTypedArray())
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(lc) else null
        return "\\draw[draw=$lineColor, $lineThickness${ifNull(fillColor, emptyString(), ", fill=$fillColor")}] $positions ${if (cycle) "-- cycle" else emptyString()};"
    }
}