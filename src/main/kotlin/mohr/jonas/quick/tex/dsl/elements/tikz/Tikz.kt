package mohr.jonas.quick.tex.dsl.elements.tikz

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Tikz(parent: DslElement?) : ParentElement(parent) {
    infix fun Number.a(n: Number) = Position(this.toFloat(), n.toFloat())

    override fun toLatexString(): String =
        StringUtils.joinWith("\n", "\\begin{tikzpicture}", *getChildren().defaultLatexStrings(), "\\end{tikzpicture}")
}