package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Preamble : ParentElement() {
    override fun toLatexString() = StringUtils.joinWith("\n", *getChildren().defaultLatexStrings())
}