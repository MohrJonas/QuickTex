package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.empty
import mohr.jonas.quick.tex.util.defaultLatexStrings
import mohr.jonas.quick.tex.util.fillTo
import org.apache.commons.lang3.StringUtils

class Table(val cols: Int) : ParentElement() {

    companion object {
        fun buildHeader(cols: Int) = "\\begin{tabular}{|${Array(cols) { "c" }.joinToString("|")}|}"
        fun buildLine(elements: List<DslElement>) = "${StringUtils.joinWith(" & ", *elements.defaultLatexStrings())} \\\\\n\\hline"
    }

    override fun toLatexString() =
        StringUtils.joinWith("\n", buildHeader(cols), *getChildren().chunked(cols).map { buildLine(it.fillTo(cols, empty())) }.toTypedArray(), "\\end{tabular}")
}