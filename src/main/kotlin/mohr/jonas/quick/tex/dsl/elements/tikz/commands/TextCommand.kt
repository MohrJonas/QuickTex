package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import mohr.jonas.quick.tex.dsl.elements.tikz.Tikz
import mohr.jonas.quick.tex.dsl.elements.tikz.Translation
import mohr.jonas.quick.tex.dsl.elements.tikz.fmt
import mohr.jonas.quick.tex.util.add
import mohr.jonas.quick.tex.util.center
import java.awt.geom.Rectangle2D

class TextCommand(
    var position: Position,
    var text: String, parent: DslElement?,
) : TikzCommand(parent) {
    override fun getBounds() = Rectangle2D.Float(position.first - 0.5f, position.second - 0.5f, 0.5f, 0.5f)

    override fun toLatexString(): String {
        val position = position.fmt()
        return "\\node[draw] at $position {$text};"
    }
}

fun Tikz.text(position: Position, text: String): TextCommand {
    val textCommand = TextCommand(position, text, this)
    addChild(textCommand)
    return textCommand
}

fun Tikz.t(position: Position, text: String) = text(position, text)

fun Translation.text(text: String): TextCommand {
    val command = TextCommand(reference.getBounds().center().add(translationX, translationY), text, reference.parent)
    (reference.parent as ParentElement).addChild(command)
    return command
}

fun Translation.t(text: String) = text(text)