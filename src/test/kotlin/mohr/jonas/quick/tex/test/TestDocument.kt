package mohr.jonas.quick.tex.test

import mohr.jonas.quick.tex.dsl.TextFormat.*
import mohr.jonas.quick.tex.dsl.elements.latex.*
import mohr.jonas.quick.tex.dsl.elements.math.*
import mohr.jonas.quick.tex.dsl.elements.tikz.ArrowType.LEFT_RIGHT
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors.*
import mohr.jonas.quick.tex.dsl.elements.tikz.LineThickness.ULTRA_THICK
import mohr.jonas.quick.tex.dsl.elements.tikz.commands.arrow
import mohr.jonas.quick.tex.dsl.elements.tikz.commands.circle
import mohr.jonas.quick.tex.dsl.elements.tikz.commands.rect
import mohr.jonas.quick.tex.dsl.elements.tikz.commands.text
import mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots.dplot
import mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots.fplot
import mohr.jonas.quick.tex.dsl.elements.tikz.pgfplots.plot
import mohr.jonas.quick.tex.dsl.elements.tikz.tikz

val document = qt {
    pre {
        pkg("tikz")
        pkg("babel", "ngerman")
        pkg("ulem")
        pkg("mathtools")
        pkg("amsmath")
        pkg("pgfplots")
        pkg("circuitikz")
        raw("\\pgfplotsset{compat=1.18}")
    }
    d {
        p {
            title("QuickTex test document", "Jonas Mohr", "25.09.2022")
            h("Text formatting")
            h("Formatting", 1)
            t("Bold text", BOLD)
            lf()
            t("Italic text", ITALIC)
            lf()
            t("Strikethrough text", STRIKETHROUGH)
            lf()
            t("Underline text", UNDERLINE)
            lf()
            t("All combined", BOLD, ITALIC, STRIKETHROUGH, UNDERLINE)
            h("Color", 1)
            c("Red text", RED)
            lf()
            t("Some")
            c("colored", LIME)
            t("text wrapped with other text")
        }
        p {
            h("Centering")
            c {
                t("Some centered text")
            }
            h("Table")
            table(3) {
                t("")
                t("Some text")
                empty()
                empty()
                empty()
                im(frac(4, 3), neq, Pi, implies, Psi)
            }
        }
        p {
            h("Pgfplots")
            tikz {
                plot(0..10, -1..1) {
                    fplot("sin(deg(x))", color = RED)
                    fplot("2 * cos(deg(x))", color = BROWN, domain = 2..8)
                    dplot(-1 a -1, 0 a 0, 1 a 1, color = CYAN, label = "Random data plot")
                }
            }
            h("Tikz")
            tikz {
                circle(0 a 0, 2, fc = BROWN, lc = ORANGE, lt = ULTRA_THICK)
                this.text(0 a 0, "!?")
                arrow(3 a 3, 0 a 0, type = LEFT_RIGHT, lc = PINK, lt = ULTRA_THICK)
                circle(0 a 4, 1).up(2).circle(1).up(2).circle(1).right(2).rect(1, 1)
            }
        }
    }
}

fun main() {
    println(document.toString())
}