package compose.project.virginmoney.domain.repository

import compose.project.virginmoney.data.model.Person
import compose.project.virginmoney.data.network.NetworkClient
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.http.HttpHeaders
import io.ktor.client.call.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class PeopleRepository(private val networkClient: NetworkClient) {
    suspend fun getPeople(): List<Person> {
        return networkClient.client.get("https://61e947967bc0550017bc61bf.mockapi.io/api/v1/people") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }.body() }
}
