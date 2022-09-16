@file:Suppress("unused", "SpellCheckingInspection")

package mohr.jonas.quick.tex.dsl.elements.math

import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.fillTo
import org.apache.commons.lang3.StringUtils

enum class VectorDirection {
    HORIZONTAL,
    VERTICAL
}

fun lim(variable: Any, to: Any): String {
    return "\\lim_{$variable \\to $to}"
}

fun sum(variable: Any, from: Any, to: Any): String {
    return "\\sum_{$variable=$from}^{$to}"
}

fun prod(variable: Any, from: Any, to: Any): String {
    return "\\prod_{$variable=$from}^{$to}"
}

fun frac(num: Any, den: Any): String {
    return "\\frac{$num}{$den}"
}

fun tilde(variable: Any): String {
    return "\\tilde{$variable}"
}

fun hat(variable: Any): String {
    return "\\hat{$variable}"
}

fun check(variable: Any): String {
    return "\\check{$variable}"
}

fun vec(variable: Any): String {
    return "\\vec{$variable}"
}

fun bar(variable: Any): String {
    return "\\bar{$variable}"
}

fun acute(variable: Any): String {
    return "\\acute{$variable}"
}

fun grave(variable: Any): String {
    return "\\grave{$variable}"
}

fun breve(variable: Any): String {
    return "\\breve{$variable}"
}

fun dot(variable: Any): String {
    return "\\dot{$variable}"
}

fun mathring(variable: Any): String {
    return "\\mathring{$variable}"
}

fun overbrace(variable: Any, overbrace: Any): String {
    return "\\overbrace{$variable}^{$overbrace}"
}

fun xleftarrow(variable: Any): String {
    return "\\xleftarrow{$variable}"
}

fun xrightarrow(variable: Any): String {
    return "\\xrightarrow{$variable}"
}

fun sqrt(variable: Any): String {
    return "\\sqrt{$variable}"
}

fun widetilde(variable: Any): String {
    return "\\widetilde{$variable}"
}

fun widehat(variable: Any): String {
    return "\\widehat{$variable}"
}

fun overline(variable: Any): String {
    return "\\overline{$variable}"
}

fun underline(variable: Any): String {
    return "\\underline{$variable}"
}

fun overrightarrow(variable: Any): String {
    return "\\overrightarrow{$variable}"
}

fun overleftarrow(variable: Any): String {
    return "\\overleftarrow{$variable}"
}

fun overleftrightarrow(variable: Any): String {
    return "\\overleftrightarrow{$variable}"
}

fun underrightarrow(variable: Any): String {
    return "\\underrightarrow{$variable}"
}

fun underleftrightarrow(variable: Any): String {
    return "\\underleftrightarrow{$variable}"
}

fun underleftarrow(variable: Any): String {
    return "\\underleftarrow{$variable}"
}

fun underbrace(variable: Any, underbrace: Any): String {
    return "\\underbrace{$variable}_{$underbrace}"
}

fun vec(vararg parts: Any, direction: VectorDirection = VectorDirection.VERTICAL) = when (direction) {
    VectorDirection.VERTICAL -> "\\begin{pmatrix}${StringUtils.joinWith("\\\\", *parts)}\\end{pmatrix}"
    VectorDirection.HORIZONTAL -> "\\(${StringUtils.joinWith("; ", *parts)}\\)"
}

fun matrix(nCols: Int, vararg parts: Any): String {
    return "\\begin{pmatrix}\n${
        StringUtils.joinWith(
            "\n",
            "${
                StringUtils.joinWith(
                    " & ",
                    parts.toList().chunked(nCols).fillTo(nCols, emptyString()).map { it.toString() })
            } \\"
        )
    }\n\\end{pmatrix}"
}