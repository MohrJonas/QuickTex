package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement

class Linebreak(parent: DslElement?) : ChildElement(parent) {
    override fun toLatexString() = "\\\\"
}