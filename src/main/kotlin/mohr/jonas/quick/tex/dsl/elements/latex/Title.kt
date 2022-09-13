package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import org.apache.commons.lang3.StringUtils

class Title(private val author: String, private val title: String, private val date: String) : ChildElement {

    override fun toLatexString(): String = StringUtils.joinWith("\n", "\\author{$author}", "\\title{$title}", "\\date{$date}", "\\maketitle")
}