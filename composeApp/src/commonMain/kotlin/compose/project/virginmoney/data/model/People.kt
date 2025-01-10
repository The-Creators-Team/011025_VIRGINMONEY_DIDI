package compose.project.virginmoney.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: String,
    val name: String,
    val contact: String
)

