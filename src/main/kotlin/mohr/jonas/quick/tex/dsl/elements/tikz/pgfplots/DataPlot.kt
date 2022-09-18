package mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors
import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import mohr.jonas.quick.tex.dsl.elements.tikz.fmt
import mohr.jonas.quick.tex.util.emptyString
import org.apache.commons.lang3.StringUtils

class DataPlot(
    private vararg val points: Position, private val label: String, private val color: Colors, parent: DslElement?
) : ChildElement(parent) {

    override fun toString(): String = StringUtils.joinWith(
        "\n",
        "\\addplot[color=${Colors.asTikzColor(color)},mark=square] coordinates {${points.joinToString("") { it.fmt() }}};",
        "\\legend{$label};"
    )
}

fun Plot.dplot(vararg points: Position, label: String = emptyString(), color: Colors = Colors.BLACK): DataPlot {
    val command = DataPlot(*points, label = label, color = color, parent = this)
    addChild(command)
    return command
}