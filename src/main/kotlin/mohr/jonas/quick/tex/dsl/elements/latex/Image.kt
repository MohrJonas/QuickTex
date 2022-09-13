package mohr.jonas.quick.tex.dsl.elements.latex

import mohr.jonas.quick.tex.Project
import mohr.jonas.quick.tex.dsl.elements.ChildElement
import mohr.jonas.quick.tex.util.downloadImage
import mohr.jonas.quick.tex.util.emptyString
import mohr.jonas.quick.tex.util.isRemote
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.relativeTo

class Image(private val source: String) : ChildElement {

    override fun toLatexString(): String {
        if (source.isBlank()) return emptyString()
        if (isRemote(source)) {
            val filePath = downloadImage(source)
            if (filePath.isEmpty) return emptyString()
            return "\\includegraphics[width=0.4\\textwidth]{${filePath.get().relativeTo(Project.workingPath)}}"
        } else {
            if (!Files.exists(Path.of(source))) {
                System.err.println("File $source doesn't exist")
                return emptyString()
            }
            return "\\includegraphics[width=0.4\\textwidth]{${Path.of(source)}}"
        }
    }
}