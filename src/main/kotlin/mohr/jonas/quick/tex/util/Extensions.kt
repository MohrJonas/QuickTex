package mohr.jonas.quick.tex.util

import mohr.jonas.quick.tex.dsl.elements.DslElement

inline fun <reified T> List<T>.fillTo(size: Int, t: T): List<T> {
    if (this.size >= size) return this
    return this.plus(Array(size - this.size) { t })
}

fun Iterable<DslElement>.defaultLatexStrings() = this.map { it.toString() }.toTypedArray()