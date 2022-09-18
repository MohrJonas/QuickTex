package mohr.jonas.quick.tex.dsl.elements.math

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.latex.Page
import org.apache.commons.lang3.StringUtils

class Math(private vararg val parts: Any, parent: DslElement?) : ChildElement(parent) {
    override fun toString(): String = StringUtils.joinWith("\n", "\\begin{gather*}", *parts, "\\end{gather*}")
}

fun ParentElement.math(firstPart: Any, vararg moreParts: Any): Math {
    val math = Math(firstPart, *moreParts, parent = this)
    addChild(math)
    return math
}

fun Page.m(firstPart: Any, vararg moreParts: Any) = math(firstPart, *moreParts)