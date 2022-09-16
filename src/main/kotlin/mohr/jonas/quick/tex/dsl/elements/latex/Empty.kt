package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.util.emptyString

class Empty(parent: DslElement?) : ChildElement(parent) {
    override fun toLatexString() = emptyString()
}