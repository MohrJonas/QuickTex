package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class Document : ParentElement() {
    override fun toLatexString() = StringUtils.joinWith("\n", "\\begin{document}", *getChildren().defaultLatexStrings(), "\\end{document}")!!
}