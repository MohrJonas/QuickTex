package mohr.jonas.quick.tex

import mohr.jonas.quick.tex.util.downloadImage
import mohr.jonas.quick.tex.util.isRemote
import mohr.jonas.quick.tex.util.sanitizeFileName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DownloadTest {

    @Test
    fun testUnreachableAddress() {
        assertTrue {
            downloadImage("https://somerandomnonexistantdomain.yxz/abcde.png").isEmpty
        }
    }

    @Test
    fun testIsRemoteAddress() {
        assertTrue(isRemote("http://google.com"))
        assertTrue(isRemote("https://youtube.com"))
        assertFalse(isRemote("/home/dev/sth"))
        assertFalse(isRemote("randompic.png"))
        assertFalse(isRemote("../.././idk.jpg"))
    }

    @Test
    fun testSanitizeFilename() {
        assertEquals("abd-._54_4.png", sanitizeFileName("abd-.@%&54|4.png"))
    }
}