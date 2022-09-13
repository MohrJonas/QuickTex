package mohr.jonas.quick.tex.output

class ConsoleOutput : Output {

    override fun process(string: String) {
        println(string)
    }
}