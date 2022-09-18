package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.TextFormat
import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement

class Text(private val content: String, private val formats: Array<TextFormat>, parent: DslElement?) :
    ChildElement(parent) {
    override fun toString(): String {
        var formatted = content
        formats.forEach { formatted = TextFormat.formatString(formatted, it) }
        return formatted
    }
}

fun ParentElement.text(content: String, vararg formats: TextFormat): Text {
    val text = Text(content, formats.toList().toTypedArray(), this)
    addChild(text)
    return text
}

fun ParentElement.t(content: String, vararg formats: TextFormat) = text(content, *formats)
