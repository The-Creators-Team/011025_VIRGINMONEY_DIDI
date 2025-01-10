package compose.project.virginmoney.data.network

import io.ktor.client.*

expect class NetworkClient {
    val client: HttpClient
}

