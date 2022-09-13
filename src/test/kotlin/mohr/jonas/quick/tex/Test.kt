package mohr.jonas.quick.tex

import mohr.jonas.quick.tex.dsl.*
import mohr.jonas.quick.tex.dsl.TextFormat.*
import mohr.jonas.quick.tex.dsl.elements.math.*
import mohr.jonas.quick.tex.dsl.elements.tikz.Colors.*
import mohr.jonas.quick.tex.dsl.elements.tikz.LineThickness.SEMITHICK
import mohr.jonas.quick.tex.dsl.elements.tikz.LineThickness.ULTRA_THICK
import mohr.jonas.quick.tex.output.ConsoleOutput
import mohr.jonas.quick.tex.output.FileOutput
import java.nio.file.Files
import kotlin.io.path.absolutePathString
import kotlin.io.path.name

val tex = QuickTex {
    preamble {
        usePackage("tikz")
        usePackage("babel", "ngerman")
        usePackage("ulem")
        usePackage("mathtools")
        usePackage("amsmath")
    }
    document {
        page {
            title("Test Document")
            heading("Large heading")
            text("some random text idk", BOLD, STRIKETHROUGH, UNDERLINE)
            heading("Smaller heading", 2)
            text("Some more text bla bla bla", ITALIC)
        }
        page {
            math {
                content = Equation(sum("x", -10, 10), frac(4, frac(9, pi)), to, Pi, prod(theta, -1, infty), implies, overbrace("Hello world", upsilon))
            }
            image("/home/jonas/Downloads/pexels-mathias-reding-13046522.jpg")
            lf()
            image("https://upload.wikimedia.org/wikipedia/commons/b/b1/Ostpreu%C3%9Fischer_Kn%C3%BCpfteppich%2C_1789%2C_Museum_Europ%C3%A4ischer_Kulturen.jpg")
        }
        page {
            tikz {
                draw(
                    0 a 0,
                    5 a 5,
                    0 a 5,
                    fc = GREEN,
                    lt = ULTRA_THICK,
                    lc = PURPLE,
                    cycle = true
                )
                text(0 a 0, "Hello World")
                rect(1 a 1, 2 a 2, lc = YELLOW, lt = SEMITHICK, fc = BROWN)
                circle(4 a 4, 1f, fc = CYAN)
                ellipse(-1 a -1, 1f, 2f, fc = RED)
            }
        }
        page {
            section("Heading content", 3)
            table(2) {
                line(text("Some"), text("Thing"), text("Discarded"))
                line(empty(), text("Hello", BOLD, STRIKETHROUGH, UNDERLINE, ITALIC))
            }
        }
    }
}

fun main() {
    System.setProperty("user.dir", "/tmp")
    //val tmpfile = Files.createTempFile("qt", ".tex")
    ConsoleOutput().process(tex.toLatexString())
    //FileOutput(tmpfile).process(tex.toLatexString())
    //ProcessBuilder("pdflatex", tmpfile.name).directory(tmpfile.parent.toFile()).inheritIO().start().waitFor().let {
    //    if (it == 0) Runtime.getRuntime().exec(arrayOf("evince", tmpfile.absolutePathString().replace(".tex", ".pdf"))).waitFor()
    //    else System.err.println("Error compiling")
    //}
}