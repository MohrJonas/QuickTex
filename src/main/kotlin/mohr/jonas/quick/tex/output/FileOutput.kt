package mohr.jonas.quick.tex.output

import java.nio.file.Files
import java.nio.file.Path

class FileOutput(private val path: Path) : Output {

    override fun process(string: String) {
        Files.writeString(path, string)
    }
}