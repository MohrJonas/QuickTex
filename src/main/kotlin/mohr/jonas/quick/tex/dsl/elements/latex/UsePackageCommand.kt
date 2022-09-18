package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.dsl.elements.DslElement
import org.apache.commons.lang3.StringUtils

class UsePackageCommand(private val pkg: String, private vararg val args: String, parent: DslElement?) :
    ChildElement(parent) {

    override fun toString() = "\\usepackage[${StringUtils.joinWith(", ", *args)}]{$pkg}"
}

fun Preamble.usePackage(pkg: String, vararg args: String): UsePackageCommand {
    val command = UsePackageCommand(pkg, *args, parent = this)
    addChild(command)
    return command
}

fun Preamble.pkg(pkg: String, vararg args: String) = usePackage(pkg, *args)