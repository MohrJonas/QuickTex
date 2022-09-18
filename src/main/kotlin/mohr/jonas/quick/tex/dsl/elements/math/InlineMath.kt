package mohr.jonas.quick.tex.dsl.elements.math

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import org.apache.commons.lang3.StringUtils

class InlineMath(private vararg val elements: Any, parent: DslElement?) : ChildElement(parent) {
    override fun toString(): String = StringUtils.wrap(StringUtils.joinWith(" ", *elements), "$")
}

fun ParentElement.inlineMath(firstPart: Any, vararg moreParts: Any): InlineMath {
    val inlineMath = InlineMath(firstPart, *moreParts, parent = this)
    addChild(inlineMath)
    return inlineMath
}

fun ParentElement.im(firstPart: Any, vararg moreParts: Any) = inlineMath(firstPart, *moreParts)