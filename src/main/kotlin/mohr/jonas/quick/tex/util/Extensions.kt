package mohr.jonas.quick.tex.util

import mohr.jonas.quick.tex.dsl.elements.DslElement
import java.util.*

fun Optional<String>.map(ifPresent: (String) -> String, ifEmpty: () -> String): String {
    return if (this.isPresent) ifPresent(this.get()) else ifEmpty()
}

inline fun <reified T> List<T>.fillTo(size: Int, t: T): List<T> {
    if (this.size >= size) return this
    return this.plus(Array(size - this.size) { t })
}

fun Iterable<DslElement>.defaultLatexStrings() = this.map { it.toString() }.toTypedArray()