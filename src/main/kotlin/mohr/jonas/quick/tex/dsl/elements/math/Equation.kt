package mohr.jonas.quick.tex.dsl.elements.math

class Equation(vararg val parts: Any) {

    override fun toString() = parts.joinToString(" ")

}