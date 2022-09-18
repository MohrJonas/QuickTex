package mohr.jonas.quick.tex.dsl.elements.tikz

enum class ArrowType {
    LEFT,
    RIGHT,
    LEFT_RIGHT;

    companion object {
        fun asTikzArrow(type: ArrowType) = when (type) {
            LEFT -> "stealth-"
            RIGHT -> "-stealth"
            LEFT_RIGHT -> "stealth-stealth"
        }
    }
}
