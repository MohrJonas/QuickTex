package mohr.jonas.quick.tex.dsl.elements.tikz.commands

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import mohr.jonas.quick.tex.dsl.elements.tikz.fmt

class TextCommand(
    private val position: Position,
    private val text: String, parent: DslElement?,
) : ChildElement(parent) {

    override fun toLatexString(): String {
        val position = position.fmt()
        return "\\node[draw] at $position {$text};"
    }
}