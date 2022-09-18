package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement

class Heading(private val level: Int, private val content: String, parent: DslElement?) : ChildElement(parent) {
    override fun toString() = "\\${"sub".repeat(level)}section*{$content}"
}

fun Page.heading(text: String, level: Int = 0): Heading {
    val heading = Heading(level.coerceIn(0, 2), text, this)
    addChild(heading)
    return heading
}

fun Page.section(text: String, level: Int) = heading(text, level)

fun Page.h(text: String, level: Int = 0) = heading(text, level)

fun Page.s(text: String, level: Int) = section(text, level)