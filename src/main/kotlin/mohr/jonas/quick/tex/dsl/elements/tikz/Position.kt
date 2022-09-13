package mohr.jonas.quick.tex.dsl.elements.tikz

import mohr.jonas.quick.tex.util.singleDec

typealias Position = Pair<Float, Float>

fun Position.fmt() = "(${first.singleDec()}, ${second.singleDec()})"