import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    // Окно можно изменять мышкой
    Window(onCloseRequest = ::exitApplication, resizable = true) {
        App()
    }
} 