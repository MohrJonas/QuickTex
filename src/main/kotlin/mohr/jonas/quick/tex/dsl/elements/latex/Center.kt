package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Center(parent: DslElement?) : ParentElement(parent) {

    override fun toString(): String =
        StringUtils.joinWith("\n", "\\begin{center}", *getChildren().defaultLatexStrings(), "\\end{center}")
}

fun ParentElement.center(init: Center.() -> Unit): Center {
    val center = Center(this)
    center.init()
    addChild(center)
    return center
}

fun ParentElement.c(init: Center.() -> Unit) = center(init)