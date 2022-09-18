package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Preamble(parent: DslElement?) : ParentElement(parent) {
    override fun toString(): String = StringUtils.joinWith("\n", *getChildren().defaultLatexStrings())
}

fun QuickTex.preamble(init: Preamble.() -> Unit): Preamble {
    val preamble = Preamble(this)
    preamble.init()
    addChild(preamble)
    return preamble
}

fun QuickTex.pre(init: Preamble.() -> Unit) = preamble(init)
