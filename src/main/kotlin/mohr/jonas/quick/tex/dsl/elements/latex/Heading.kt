package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement

class Heading(private val level: Int, private val content: String) : ChildElement {
    override fun toLatexString() = "\\${"sub".repeat(level)}section*{$content}"
}