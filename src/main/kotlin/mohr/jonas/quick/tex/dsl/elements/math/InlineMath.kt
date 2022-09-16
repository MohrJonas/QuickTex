package mohr.jonas.quick.tex.dsl.elements.math

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import org.apache.commons.lang3.StringUtils

class InlineMath(private vararg val elements: Any, parent: DslElement?) : ChildElement(parent) {
    override fun toLatexString(): String = StringUtils.wrap(StringUtils.joinWith(" ", *elements), "$")
}