@file:Suppress("MemberVisibilityCanBePrivate")

package mohr.jonas.quick.tex

import java.nio.file.Files
import java.nio.file.Path

object Project {

    val workingPath: Path = Path.of(System.getProperty("user.dir"))
    val assetPath: Path = workingPath.resolve("assets")
    val sourcePath: Path = workingPath.resolve("src")
    val outPath: Path = workingPath.resolve("out")

    private fun setupStructure() {
        if (!Files.exists(assetPath)) Files.createDirectory(assetPath)
        if (!Files.exists(sourcePath)) Files.createDirectory(sourcePath)
        if (!Files.exists(outPath)) Files.createDirectory(outPath)
    }

    init {
        setupStructure()
    }
}