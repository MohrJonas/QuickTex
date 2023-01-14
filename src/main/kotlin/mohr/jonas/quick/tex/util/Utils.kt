package mohr.jonas.quick.tex.util

import mohr.jonas.quick.tex.dsl.elements.tikz.Position
import org.apache.commons.lang3.StringUtils
import java.awt.geom.Rectangle2D
import java.time.LocalDate
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

//I know this is useless, but I find return emtpyString() looks a lot better that return ""
fun emptyString() = ""

fun getDateString(): String {
    val formatter = DateTimeFormatterBuilder().appendValue(ChronoField.DAY_OF_MONTH, 2).appendLiteral(".")
        .appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral(".").appendValue(ChronoField.YEAR, 4).toFormatter()
    return LocalDate.now().format(formatter)
}

fun <T, U> ifNull(u: U?, ifNull: T, ifnNull: T): T {
    return if (u == null) ifNull else ifnNull
}

fun Float.singleDec() = this.toString()

fun Position.add(x: Number, y: Number) = Position(first + x.toFloat(), second + y.toFloat())

fun Rectangle2D.Float.center() = Position(centerX.toFloat(), centerY.toFloat())

fun j(vararg parts: Any) = StringUtils.joinWith(" ", *parts.map { it.toString() }.toTypedArray())