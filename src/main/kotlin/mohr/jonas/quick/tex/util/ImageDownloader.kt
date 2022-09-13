package mohr.jonas.quick.tex.util

import mohr.jonas.quick.tex.Project
import org.apache.commons.io.FilenameUtils
import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.filter.ClientFilters
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

fun downloadImage(source: String): Optional<Path> {
    val filePath = Project.assetPath.resolve(sanitizeFileName(FilenameUtils.getName(source)))
    if(Files.exists(filePath)) {
        println("Using cached version of $source")
         return Optional.of(filePath)
    }
    val client = ClientFilters.FollowRedirects().invoke(ApacheClient())
    val request = Request(Method.GET, source)
    val response = client(request)
    if (response.status != Status.OK) {
        System.err.println("Unable to download picture $source, reason: ${response.status.description}")
        return Optional.empty()
    }
    Files.write(filePath, response.body.payload.array())
    return Optional.of(filePath)
}