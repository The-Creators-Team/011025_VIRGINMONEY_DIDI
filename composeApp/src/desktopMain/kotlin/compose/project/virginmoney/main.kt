package compose.project.virginmoney

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.project.virginmoney.domain.startKoin

fun main() {

    startKoin()

    application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Virgin Money Application",
    ) {
        App()
    }
}}