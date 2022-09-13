package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement

class Linebreak : ChildElement {
    override fun toLatexString() = "\\\\"
}