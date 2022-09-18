package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement

class Image(private val source: String, parent: DslElement?) : ChildElement(parent) {
    override fun toString() = "\\includegraphics[width=0.4\\textwidth]{$source}"
}

fun ParentElement.image(source: String): Image {
    val image = Image(source, this)
    addChild(image)
    return image
}

fun ParentElement.i(source: String) = image(source)
