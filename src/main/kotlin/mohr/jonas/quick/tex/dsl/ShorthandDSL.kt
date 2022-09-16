@file:Suppress("unused")

package mohr.jonas.quick.tex.dsl

import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.latex.*
import mohr.jonas.quick.tex.dsl.elements.tikz.Tikz
import mohr.jonas.quick.tex.util.getDateString
import org.apache.commons.lang3.StringUtils

fun qt(init: QuickTex.() -> Unit) = quickTex(init)

fun QuickTex.pre(init: Preamble.() -> Unit) = preamble(init)

fun QuickTex.d(init: Document.() -> Unit) = document(init)

fun Document.p(init: Page.() -> Unit) = page { init() }

fun Page.h(text: String, level: Int = 0) = heading(text, level)

fun Page.s(text: String, level: Int) = heading(text, level)

fun ParentElement.t(cols: Int, init: Table.() -> Unit) = table(cols) { init() }

fun ParentElement.i(source: String) = image(source)

fun Page.t(
    titlee: String,
    author: String = StringUtils.capitalize(System.getProperty("user.name")),
    date: String = getDateString()
) = title(titlee, author, date)

fun ParentElement.t(init: Tikz.() -> Unit) = tikz { init() }

fun ParentElement.t(content: String, vararg formats: TextFormat) = text(content, *formats)

fun Preamble.pkg(pkg: String, vararg args: String) = usePackage(pkg, *args)

fun ParentElement.r(command: String) = raw(command)

fun Table.e() = empty()

fun ParentElement.m(firstPart: Any, vararg moreParts: Any) = math(firstPart, *moreParts)

fun ParentElement.im(firstPart: Any, vararg moreParts: Any) = inlineMath(firstPart, *moreParts)