import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

private val AppleColors = lightColors(
    primary = Color(0xFF007AFF), // Яблочный синий
    primaryVariant = Color(0xFF0055FF),
    secondary = Color(0xFF5856D6), // Яблочный фиолетовый
    background = Color(0xFFF2F2F7), // Яблочный светло-серый
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000)
)

private val AppleTypography = Typography(
    body1 = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)

private val AppleShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp)
)

@Composable
fun App() {
    var buttonText by remember { mutableStateOf("Нажми меня") }
    var inputText by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    MaterialTheme(
        colors = AppleColors,
        typography = AppleTypography,
        shapes = AppleShapes
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                TextField(
                    value = inputText,
                    onValueChange = { newValue ->
                        // Разрешаем только цифры
                        if (newValue.isEmpty() || newValue.all { it.isDigit() }) {
                            inputText = newValue
                            isError = false
                        } else {
                            isError = true
                        }
                    },
                    label = { Text("Введите число") },
                    isError = isError,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = AppleColors.primary,
                        unfocusedIndicatorColor = Color.Gray
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Кнопка для установки текста
                Button(
                    onClick = {
                        if (inputText.isNotEmpty()) {
                            buttonText = inputText
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AppleColors.primary
                    ),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text(buttonText)
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Кнопка для очистки
                Button(
                    onClick = {
                        inputText = ""
                        buttonText = "Нажми меня"
                        isError = false
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = AppleColors.secondary
                    ),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text("Очистить")
                }
            }
        }
    }
} 