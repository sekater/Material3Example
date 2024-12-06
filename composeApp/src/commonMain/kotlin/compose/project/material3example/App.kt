package compose.project.material3example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        // Buttons()
        // TextFields()
        // Badges()
        ProgressIndicators()
    }
}

@Composable
fun Buttons() {
    Box(modifier = Modifier.size(580.dp, 400.dp).background(Color.White).padding(10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Button(elevation = null, onClick = { println("Clicked") }) {
                    Text("Filled")
                }
                FilledTonalButton(onClick = { println("Clicked") }) {
                    Text("Tonal")
                }
                ElevatedButton(onClick = { println("Clicked") }) {
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
                OutlinedButton(onClick = { println("Clicked") }) {
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
                    ) {
                        Icon(Icons.Filled.Add, "Floating action button")
                    }
                    SmallFloatingActionButton(
                        onClick = { println("Clicked") },
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary
                    ) {
                        Icon(Icons.Filled.Add, "Small floating action button.")
                    }
                    LargeFloatingActionButton(
                        onClick = { println("Clicked") },
                        shape = CircleShape,
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.secondary
                    ) {
                        Icon(Icons.Filled.Add, "Large floating action button")
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
    val state = rememberTextFieldState()
    var isError by rememberSaveable { mutableStateOf(false) }

    fun validate(text: CharSequence) {
        isError = text.length > 10
    }
    LaunchedEffect(Unit) {
        snapshotFlow { state.text }.collect { validate(it) }
    }
    Box(modifier = Modifier.size(580.dp, 400.dp).background(Color.White).padding(10.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(
                "Text fields", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            TextField(
                state = state,
                lineLimits = TextFieldLineLimits.SingleLine,
                label = { Text(if (isError) "Error" else "Filled") },
                placeholder = { Text("Placeholder") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { state.clearText() }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
                supportingText = {
                    Row {
                        Text(if (isError) ("Error limit") else "")
                        Spacer(Modifier.weight(1f))
                        Text("Limit: ${state.text.length}/10")
                    }
                },
            )
            TextField(
                state = state,
                lineLimits = TextFieldLineLimits.SingleLine,
                label = { Text("Filled") },
                placeholder = { Text("Placeholder") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { state.clearText() }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
                isError = true,
                supportingText = { Text("Error text") },
            )
            OutlinedTextField(
                state = state,
                label = { Text("Outlined") },
                placeholder = { Text("Placeholder") },
                trailingIcon = {
                    IconButton(onClick = { state.clearText() }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
            )
            TextField(
                state = rememberTextFieldState(),
                lineLimits = TextFieldLineLimits.SingleLine,
                label = { Text("Disabled") },
                placeholder = { Text("Placeholder") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { state.clearText() }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
                supportingText = { Text("Test text") },
                enabled = false
            )
        }
    }
}

@Composable
fun Badges() {
    Text(
        "Badges", style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    )
    NavigationBar {
        var selectedItem by remember { mutableIntStateOf(0) }
        val items = listOf("Mail", "Notification", "Home")
        val selectedIcons =
            listOf(Icons.Filled.Email, Icons.Filled.Notifications, Icons.Filled.Home)
        val unselectedIcons =
            listOf(Icons.Outlined.MailOutline, Icons.Outlined.Notifications, Icons.Outlined.Home)
        val badges = listOf("999+", "10", "")
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = {
                                if (badges[index] != "") {
                                    Badge { Text(badges[index]) }
                                } else {
                                    Badge()
                                }
                            }
                        ) {
                            Icon(
                                if (selectedItem == index)
                                    selectedIcons[index]
                                else unselectedIcons[index],
                                contentDescription = item
                            )
                        }
                    },
                    label = { Text(item) },
                    selected = selectedItem == index,
                    onClick = { selectedItem = index })
            }
        }
    }
}

@Composable
fun ProgressIndicators() {
    Text(
        "Progress Indicators", style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    )
    var loading by remember { mutableStateOf(false) }
    IconButton(onClick = {
        if (!loading) {
            loading = true
        } else {
            loading = false
        }
    }) {
        Icon(Icons.Filled.PlayArrow, contentDescription = "")
    }
    if (loading) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        CircularProgressIndicator(modifier = Modifier.size(100.dp))
    }
}