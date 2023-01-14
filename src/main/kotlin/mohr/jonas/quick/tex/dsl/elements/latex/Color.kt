package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors

class Color(private val text: String, private val color: Colors, parent: DslElement?) : ChildElement(parent) {

    override fun toString() = "\\textcolor{${Colors.asTikzColor(color)}}{$text}"
}

fun ParentElement.color(text: String, color: Colors) = c(text, color)

fun ParentElement.c(text: String, color: Colors): Color {
    val color = Color(text, color, this)
    addChild(color)
    return color
}