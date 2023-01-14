package mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors
import org.apache.commons.lang3.StringUtils

class FunctionPlot(
    private val function: String, private val domain: IntRange, private val color: Colors, parent: DslElement?
) : ChildElement(parent) {

    override fun toString(): String = StringUtils.joinWith(
        "\n",
        "\\addplot[color=${Colors.asTikzColor(color)}, domain=${domain.first}:${domain.last}] {$function};",
        "\\addlegendentry{${StringUtils.wrap(function, "$")}}"
    )
}

fun Plot.fplot(
    function: String, domain: IntRange = this.xRange.first..this.xRange.last, color: Colors = Colors.BLACK
): FunctionPlot {
    val command = FunctionPlot(function, domain, color, this)
    addChild(command)
    return command
}