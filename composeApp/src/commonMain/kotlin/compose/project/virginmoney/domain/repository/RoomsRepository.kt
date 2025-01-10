package compose.project.virginmoney.domain.repository

import compose.project.virginmoney.data.model.Room
import compose.project.virginmoney.data.network.NetworkClient
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.http.HttpHeaders
import io.ktor.client.call.*
import io.ktor.http.*

class RoomsRepository(private val networkClient: NetworkClient) {
    suspend fun getRooms(): List<Room> {
        return networkClient.client.get("https://61e947967bc0550017bc61bf.mockapi.io/api/v1/rooms") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }.body()}
}
