package compose.project.virginmoney.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id: String,
    val name: String,
    val occupied: Boolean
)
