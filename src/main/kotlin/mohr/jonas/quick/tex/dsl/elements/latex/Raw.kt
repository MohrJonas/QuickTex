package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement

class Raw(private val rawText: String, parent: DslElement?) : ChildElement(parent) {
    override fun toString() = rawText
}

fun ParentElement.raw(command: String): Raw {
    val raw = Raw(command, this)
    addChild(raw)
    return raw
}

fun ParentElement.r(command: String) = raw(command)

