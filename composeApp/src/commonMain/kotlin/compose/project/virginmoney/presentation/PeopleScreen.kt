package compose.project.virginmoney.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.project.virginmoney.data.model.Person
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PeopleScreen(people: List<Person>) {
    Column(modifier = Modifier.padding(16.dp)) {
        people.forEach { person ->
            Text("Name: ${person.name}, Contact: ${person.contact}")
        }
    }
}
