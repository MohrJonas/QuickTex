package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.util.emptyString

class Empty : ChildElement {
    override fun toLatexString() = emptyString()
}