package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement

class Heading(private val level: Int, private val content: String, parent: DslElement?) : ChildElement(parent) {
    override fun toLatexString() = "\\${"sub".repeat(level)}section*{$content}"
}