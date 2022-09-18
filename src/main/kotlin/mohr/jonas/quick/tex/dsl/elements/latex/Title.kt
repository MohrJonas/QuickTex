package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import mohr.jonas.quick.tex.util.getDateString
import org.apache.commons.lang3.StringUtils

class Title(private val author: String, private val title: String, private val date: String, parent: DslElement?) :
    ChildElement(parent) {

    override fun toString(): String =
        StringUtils.joinWith("\n", "\\author{$author}", "\\title{$title}", "\\date{$date}", "\\maketitle")
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