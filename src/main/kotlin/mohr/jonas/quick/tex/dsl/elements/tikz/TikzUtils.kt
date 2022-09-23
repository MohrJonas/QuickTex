package mohr.jonas.quick.tex.dsl.elements.tikz

fun getYAt(startPoint: Position, endPoint: Position, x: Number): Float =
    x.toFloat() * ((endPoint.second - startPoint.second) / (endPoint.first - startPoint.first))