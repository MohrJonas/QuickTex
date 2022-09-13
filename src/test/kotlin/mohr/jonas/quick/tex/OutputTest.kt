package mohr.jonas.quick.tex

import mohr.jonas.quick.tex.output.FileOutput
import kotlin.test.Test
import java.nio.file.Files
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class OutputTest {

    @Test
    fun testFileOutput() {
        val tmpFile = Files.createTempFile("qt", ".test")
        FileOutput(tmpFile).process("somerandomstring")
        assertTrue(Files.exists(tmpFile))
        assertEquals(Files.readString(tmpFile), "somerandomstring")
    }
}