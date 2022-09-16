@file:Suppress("unused")

package mohr.jonas.quick.tex.dsl.elements.tikz

enum class LineThickness {
    ULTRA_THIN,
    VERY_THIN,
    THIN,
    SEMITHICK,
    THICK,
    VERY_THICK,
    ULTRA_THICK;

    companion object {
        fun asTikzThickness(thickness: LineThickness) = thickness.toString().lowercase().replace("_", " ")
    }
}