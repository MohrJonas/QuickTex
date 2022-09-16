package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.tikz.*
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.ifNull
import org.apache.commons.lang3.StringUtils
import java.awt.geom.Rectangle2D

class DrawCommand(
    private vararg val positions: Position,
    var fc: Colors?,
    var lc: Colors,
    var lt: LineThickness,
    var cycle: Boolean, parent: DslElement?
) : TikzCommand(parent) {
    override fun getBounds(): Rectangle2D.Float {
        val minX = positions.minBy { it.first }.first
        val minY = positions.minBy { it.second }.second
        val maxX = positions.maxBy { it.first }.first
        val maxY = positions.maxBy { it.second }.second
        return Rectangle2D.Float(maxX - (maxX - minX), maxY - (maxY - minY), maxX - minX, maxY - minY)
    }

    override fun toLatexString(): String {
        val positions = StringUtils.joinWith(" -- ", *positions.map { it.fmt() }.toTypedArray())
        val lineColor = Colors.asTikzColor(lc)
        val lineThickness = LineThickness.asTikzThickness(lt)
        val fillColor = if (fc != null) Colors.asTikzColor(fc!!) else null
        return "\\draw[draw=$lineColor, $lineThickness${
            ifNull(
                fillColor,
                emptyString(),
                ", fill=$fillColor"
            )
        }] $positions ${if (cycle) "-- cycle" else emptyString()};"
    }
}

fun Tikz.draw(
    vararg positions: Position,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
    cycle: Boolean = false
): DrawCommand {
    val command = DrawCommand(*positions, fc = fc, lc = lc, lt = lt, cycle = cycle, parent = this)
    addChild(command)
    return command
}

fun Tikz.d(
    vararg positions: Position,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
    cycle: Boolean = false
) = draw(*positions, fc = fc, lc = lc, lt = lt, cycle = cycle)