package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import org.apache.commons.lang3.StringUtils

class UsePackageCommand(private val pkg: String, private vararg val args: String, parent: DslElement?) :
    ChildElement(parent) {

    override fun toLatexString() = "\\usepackage[${StringUtils.joinWith(", ", *args)}]{$pkg}"
}