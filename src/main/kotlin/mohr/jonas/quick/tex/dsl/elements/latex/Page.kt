package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Page(parent: DslElement?) : ParentElement(parent) {
    override fun toString(): String =
        StringUtils.joinWith("\n", *getChildren().defaultLatexStrings(), "\\pagebreak")
}

fun Document.page(init: Page.() -> Unit): Page {
    val page = Page(this)
    page.init()
    addChild(page)
    return page
}

fun Document.p(init: Page.() -> Unit) = page { init() }