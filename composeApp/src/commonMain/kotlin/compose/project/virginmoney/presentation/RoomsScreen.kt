package compose.project.virginmoney.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.project.virginmoney.data.model.Room

@Composable
fun RoomsScreen(rooms: List<Room>) {
    Column(modifier = Modifier.padding(16.dp)) {
        rooms.forEach { room ->
            Text("Room: ${room.name}, Occupied: ${if (room.occupied) "Yes" else "No"}")
        }
    }
}
