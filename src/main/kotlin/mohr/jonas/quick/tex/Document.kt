package mohr.jonas.quick.tex

import mohr.jonas.quick.tex.dsl.elements.latex.QuickTex

interface Document {

    fun get(): QuickTex

}