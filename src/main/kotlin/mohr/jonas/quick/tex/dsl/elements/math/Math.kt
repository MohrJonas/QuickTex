package mohr.jonas.quick.tex.dsl.elements.math

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import org.apache.commons.lang3.StringUtils

class Math : ChildElement {

    var content = Equation()

    override fun toLatexString(): String = StringUtils.joinWith("\n", "\\begin{gather*}", content.toString(), "\\end{gather*}")
}