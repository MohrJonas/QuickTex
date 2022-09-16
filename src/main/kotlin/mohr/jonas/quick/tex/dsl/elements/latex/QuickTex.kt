package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.dsl.elements.ParentElement
import mohr.jonas.quick.tex.util.defaultLatexStrings
import org.apache.commons.lang3.StringUtils

class QuickTex : ParentElement(null) {

    override fun toLatexString(): String =
        StringUtils.joinWith("\n", "\\documentclass[12pt]{article}", *getChildren().defaultLatexStrings())
}