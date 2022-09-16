@file:Suppress("unused")

package mohr.jonas.quick.tex.dsl.elements.tikz

enum class Colors {
    RED,
    GREEN,
    BLUE,
    CYAN,
    MAGENTA,
    YELLOW,
    BLACK,
    GRAY,
    DARKGRAY,
    LIGHTGRAY,
    BROWN,
    LIME,
    OLIVE,
    ORANGE,
    PINK,
    PURPLE,
    TEAL,
    VIOLET,
    WHITE;

    companion object {
        fun asTikzColor(colors: Colors) = colors.toString().lowercase()
    }
}