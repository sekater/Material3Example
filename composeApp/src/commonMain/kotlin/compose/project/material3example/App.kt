package compose.project.material3example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//@Composable
//@Preview
//fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}

@Composable
fun App() {
    Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
        Buttons()
        TextFields()
    }
}

@Composable
fun Buttons() {
    Box(modifier = Modifier.background(Color.White).padding(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Button(elevation = null, onClick = { println("Clicked") }) {
                    Text("Filled")
                }
                FilledTonalButton(onClick = { println("Clicked") }) {
                    Text("Tonal")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB0BEC5),
                        contentColor = MaterialTheme.colorScheme.onSurface
                    ), onClick = { println("Clicked") }) {
                    Text("Tonal")
                }
                Button(
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 8.dp,
                        disabledElevation = 0.dp,
                        hoveredElevation = 4.dp,
                        focusedElevation = 4.dp
                    ), onClick = { println("Clicked") }) {
                    Text("Elevated")
                }
                OutlinedButton(onClick = { println("Clicked") }) {
                    Text("Outlined")
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Button(enabled = false, onClick = { println("Clicked") }) {
                    Text("Disabled")
                }
                TextButton(onClick = { println("Clicked") }) {
                    Text("Text Button")
                }
                Button(onClick = { println("Clicked") }) {
                    Icon(Icons.Filled.Add, "")
                    Text("Text Button")
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Floating action buttons")
                    FloatingActionButton(
                        onClick = { println("Clicked") },
                        modifier = Modifier.size(72.dp)
                    ) {
                        Icon(Icons.Filled.Add, "Floating action button")
                    }

                    FloatingActionButton(
                        onClick = { println("Clicked") },
                        shape = MaterialTheme.shapes.large
                    ) {
                        Icon(Icons.Filled.Add, "Small floating action button.")
                    }
                    FloatingActionButton(
                        onClick = { println("Clicked") },
                        modifier = Modifier.size(45.dp)
                    )
                    {
                        Icon(Icons.Filled.Add, "")
                    }
                    ExtendedFloatingActionButton(
                        onClick = { println("Clicked") },
                        icon = { Icon(Icons.Filled.Add, "Extended floating action") },
                        text = { Text(text = "Button") },
                    )
                    ExtendedFloatingActionButton(
                        onClick = { println("Clicked") },
                        icon = { Icon(Icons.Filled.Edit, "Extended floating action") },
                        text = { Text(text = "Test") },
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Text("Icon buttons")
                    IconButton(onClick = { println("Clicked") }) {
                        Icon(Icons.Filled.Favorite, contentDescription = "Description")
                    }
                    IconButton(enabled = false, onClick = { println("Clicked") }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Description")
                    }
                }
            }
        }
    }
}

@Composable
fun TextFields() {
    Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
        Text("Text fields")
        TextField(
            state = rememberTextFieldState(),
            lineLimits = TextFieldLineLimits.SingleLine,
            label = { Text("Filled") },
            placeholder = { Text("Placeholder") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear") },
            supportingText = {Text("SupportingText") },
        )
        TextField(
            state = rememberTextFieldState(),
            lineLimits = TextFieldLineLimits.SingleLine,
            label = { Text("Error") },
            placeholder = { Text("Placeholder") },
            isError = true,
        )
        OutlinedTextField(
            state = rememberTextFieldState(),
            label = { Text("Outlined") },
            trailingIcon = { Icon(Icons.Default.Clear, contentDescription = "Clear") },
        )
        TextField(
            state = rememberTextFieldState(),
            lineLimits = TextFieldLineLimits.SingleLine,
            label = { Text("Disabled") },
            placeholder = { Text("Placeholder") },
            enabled = false
        )
    }
}