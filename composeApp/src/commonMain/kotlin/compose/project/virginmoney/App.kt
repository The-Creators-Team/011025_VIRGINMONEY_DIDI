package compose.project.virginmoney

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import compose.project.virginmoney.data.model.Person
import compose.project.virginmoney.data.model.Room
import compose.project.virginmoney.data.network.NetworkClient
import compose.project.virginmoney.domain.repository.PeopleRepository
import compose.project.virginmoney.domain.repository.RoomsRepository
import compose.project.virginmoney.presentation.PeopleScreen
import compose.project.virginmoney.presentation.RoomsScreen
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import virginmoneyapplication.composeapp.generated.resources.Res
import virginmoneyapplication.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    // Store the current screen in a state variable
    var selectedTab by remember { mutableStateOf("People") }

    // Use coroutine scope for launching async tasks
    val coroutineScope = rememberCoroutineScope()

    // State to store the list of people and rooms
    var people = emptyList<Person>()
    var rooms = emptyList<Room>()

    // Create instances of repositories (use dependency injection in real projects)
    val networkClient = NetworkClient()
    val peopleRepo = PeopleRepository(networkClient)
    val roomsRepo = RoomsRepository(networkClient)

    Column {
        TopAppBar(title = { Text("People and Rooms App") })

        // Bottom navigation to switch between people and rooms
        BottomNavigation {
            BottomNavigationItem(
                icon = { /* Your icon */ },
                label = { Text("People") },
                selected = selectedTab == "People",
                onClick = {
                    selectedTab = "People"
                    coroutineScope.launch {
                        people = peopleRepo.getPeople() // Fetch people
                    }
                }
            )

            BottomNavigationItem(
                icon = { /* Your icon */ },
                label = { Text("Rooms") },
                selected = selectedTab == "Rooms",
                onClick = {
                    selectedTab = "Rooms"
                    coroutineScope.launch {
                        rooms = roomsRepo.getRooms() // Fetch rooms
                    }
                }
            )
        }

        // Show content based on selected tab
        when (selectedTab) {
            "People" -> PeopleScreen(people)
            "Rooms" -> RoomsScreen(rooms)
        }
    }
}
