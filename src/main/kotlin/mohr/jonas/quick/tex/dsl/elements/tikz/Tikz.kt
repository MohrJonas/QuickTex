package mohr.jonas.quick.tex.dsl.elements.tikz

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

@Suppress("Unused")
class Tikz(parent: DslElement?) : ParentElement(parent) {

    infix fun Int.a(i: Int) = Position(this.toFloat(), i.toFloat())
    infix fun Float.a(f: Float) = Position(this, f)

    override fun toLatexString(): String =
        StringUtils.joinWith("\n", "\\begin{tikzpicture}", *getChildren().defaultLatexStrings(), "\\end{tikzpicture}")
}