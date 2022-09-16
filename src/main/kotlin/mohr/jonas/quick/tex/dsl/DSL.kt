@file:Suppress("unused")

package mohr.jonas.quick.tex.dsl

import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.latex.*
import mohr.jonas.quick.tex.dsl.elements.math.InlineMath
import mohr.jonas.quick.tex.dsl.elements.math.Math
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors
import mohr.jonas.quick.tex.dsl.elements.tikz.LineThickness
import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import mohr.jonas.quick.tex.dsl.elements.tikz.Tikz
import mohr.jonas.quick.tex.dsl.elements.tikz.commands.*
import mohr.jonas.quick.tex.util.getDateString
import org.apache.commons.lang3.StringUtils

fun quickTex(init: QuickTex.() -> Unit): QuickTex {
    val tex = QuickTex()
    tex.init()
    return tex
}

fun QuickTex.preamble(init: Preamble.() -> Unit): Preamble {
    val preamble = Preamble(this)
    preamble.init()
    addChild(preamble)
    return preamble
}

fun QuickTex.document(init: Document.() -> Unit): Document {
    val doc = Document(this)
    doc.init()
    addChild(doc)
    return doc
}

fun Document.page(init: Page.() -> Unit): Page {
    val page = Page(this)
    page.init()
    addChild(page)
    return page
}

fun Page.heading(text: String, level: Int = 0): Heading {
    val heading = Heading(level.coerceIn(0, 2), text, this)
    addChild(heading)
    return heading
}

fun Page.section(text: String, level: Int) = heading(text, level)

fun ParentElement.table(cols: Int, init: Table.() -> Unit): Table {
    val table = Table(cols.coerceAtLeast(1), this)
    table.init()
    addChild(table)
    return table
}

fun ParentElement.image(source: String): Image {
    val image = Image(source, this)
    addChild(image)
    return image
}

fun Page.lf(): Linebreak {
    val linebreak = Linebreak(this)
    addChild(linebreak)
    return linebreak
}

fun Page.title(
    titlee: String,
    author: String = StringUtils.capitalize(System.getProperty("user.name")),
    date: String = getDateString()
): Title {
    val title = Title(author, titlee, date, this)
    addChild(title)
    return title
}

fun ParentElement.tikz(init: Tikz.() -> Unit): Tikz {
    val tikz = Tikz(this)
    tikz.init()
    addChild(tikz)
    return tikz
}

fun ParentElement.text(content: String, vararg formats: TextFormat): Text {
    val text = Text(content, formats.toList().toTypedArray(), this)
    addChild(text)
    return text
}

fun Preamble.usePackage(pkg: String, vararg args: String): UsePackageCommand {
    val command = UsePackageCommand(pkg, *args, parent = this)
    addChild(command)
    return command
}

fun ParentElement.raw(command: String): Raw {
    val raw = Raw(command, this)
    addChild(raw)
    return raw
}

fun Tikz.circle(
    position: Position,
    radius: Float,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): CircleCommand {
    val command = CircleCommand(position, radius, fc, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.draw(
    vararg positions: Position,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK,
    cycle: Boolean = false
): DrawCommand {
    val command = DrawCommand(*positions, fc = fc, lc = lc, lt = lt, cycle = cycle, parent = this)
    addChild(command)
    return command
}

fun Tikz.ellipse(
    position: Position,
    radiusX: Float,
    radiusY: Float,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): EllipseCommand {
    val command = EllipseCommand(position, radiusX, radiusY, fc, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.rect(
    position1: Position,
    position2: Position,
    fc: Colors? = null,
    lc: Colors = Colors.BLACK,
    lt: LineThickness = LineThickness.SEMITHICK
): RectCommand {
    val command = RectCommand(position1, position2, fc, lc, lt, this)
    addChild(command)
    return command
}

fun Tikz.text(position: Position, text: String): TextCommand {
    val textCommand = TextCommand(position, text, this)
    addChild(textCommand)
    return textCommand
}

fun Table.empty(): Empty {
    val empty = Empty(this)
    addChild(empty)
    return empty
}

fun ParentElement.math(firstPart: Any, vararg moreParts: Any): Math {
    val math = Math(firstPart, *moreParts, parent = this)
    addChild(math)
    return math
}

fun ParentElement.inlineMath(firstPart: Any, vararg moreParts: Any): InlineMath {
    val inlineMath = InlineMath(firstPart, *moreParts, parent = this)
    addChild(inlineMath)
    return inlineMath
}