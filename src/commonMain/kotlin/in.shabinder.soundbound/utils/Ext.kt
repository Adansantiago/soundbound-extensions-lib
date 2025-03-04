package `in`.shabinder.soundbound.utils

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

/*
* Return URL after Redirections
*   - If Fails returns Input Url
* */
suspend inline fun HttpClient.getFinalUrl(
    url: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): String {
    return runCatching {
        get(url, block).call.request.url.toString()
    }.getOrNull() ?: url
}

internal inline fun List<String>.cleaned(): ImmutableList<String> {
    return this.filter { it.isNotBlank() && it != "null" }.toImmutableList()
}
