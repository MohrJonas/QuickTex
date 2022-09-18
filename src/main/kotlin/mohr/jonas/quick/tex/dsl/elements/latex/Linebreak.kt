package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement

class Linebreak(parent: DslElement?) : ChildElement(parent) {
    override fun toString() = "\\\\"
}

fun ParentElement.lf(): Linebreak {
    val linebreak = Linebreak(this)
    addChild(linebreak)
    return linebreak
}

