package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement

class Raw(private val rawText: String) : ChildElement {
    override fun toLatexString() = rawText
}