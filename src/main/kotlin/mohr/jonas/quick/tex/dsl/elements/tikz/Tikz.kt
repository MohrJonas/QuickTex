package mohr.jonas.quick.tex.dsl.elements.tikz

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Tikz(parent: DslElement?) : ParentElement(parent) {
    infix fun Number.a(n: Number) = Position(this.toFloat(), n.toFloat())

    override fun toString(): String =
        StringUtils.joinWith("\n", "\\begin{tikzpicture}", *getChildren().defaultLatexStrings(), "\\end{tikzpicture}")
}

fun ParentElement.tikz(init: Tikz.() -> Unit): Tikz {
    val tikz = Tikz(this)
    tikz.init()
    addChild(tikz)
    return tikz
}