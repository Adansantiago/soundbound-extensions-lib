package `in`.shabinder.soundbound.providers

import androidx.compose.runtime.Immutable
import `in`.shabinder.soundbound.utils.Context
import `in`.shabinder.soundbound.utils.DevicePreferences
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import kotlinx.coroutines.CoroutineScope

@Immutable
interface Dependencies {
    val appContext: Context
    val appScope: CoroutineScope
    val devicePreferences: DevicePreferences
    val httpClientBuilder: (
        usePreConfig: Boolean,
        block: HttpClientConfig<*>.() -> Unit
    ) -> HttpClient
}
