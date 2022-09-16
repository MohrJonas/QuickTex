package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement

class Image(private val source: String, parent: DslElement?) : ChildElement(parent) {
    override fun toLatexString() = "\\includegraphics[width=0.4\\textwidth]{$source}"
}