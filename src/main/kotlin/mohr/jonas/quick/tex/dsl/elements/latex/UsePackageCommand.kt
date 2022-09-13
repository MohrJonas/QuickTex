package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import org.apache.commons.lang3.StringUtils

class UsePackageCommand(private val pkg: String, private vararg val args: String) : ChildElement {

    override fun toLatexString() = "\\usepackage[${StringUtils.joinWith(", ", *args)}]{$pkg}"
}