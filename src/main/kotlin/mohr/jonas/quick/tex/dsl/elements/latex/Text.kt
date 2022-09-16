package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.TextFormat
import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement

class Text(private val content: String, private val formats: Array<TextFormat>, parent: DslElement?) :
    ChildElement(parent) {
    override fun toLatexString(): String {
        var formatted = content
        formats.forEach { formatted = TextFormat.formatString(formatted, it) }
        return formatted
    }
}