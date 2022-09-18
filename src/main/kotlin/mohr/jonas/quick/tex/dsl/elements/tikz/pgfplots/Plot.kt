package mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Tikz
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Plot(
    private val xRange: IntRange,
    private val yRange: IntRange,
    parent: DslElement?
) : ParentElement(parent) {

    override fun toString(): String =
        StringUtils.joinWith(
            "\n",
            "\\begin{axis}[axis lines = left, xlabel = \\(x\\), ylabel = {\\(f(x)\\)}, xmin = ${xRange.first}, xmax = ${xRange.last}, ymin = ${yRange.first}, ymax = ${yRange.last}]",
            *getChildren().defaultLatexStrings(),
            "\\end{axis}"
        )

}

fun Tikz.plot(xRange: IntRange = -5..5, yRange: IntRange = -5..5, init: Plot.() -> Unit): Plot {
    val plot = Plot(xRange, yRange, this)
    plot.init()
    addChild(plot)
    return plot
}