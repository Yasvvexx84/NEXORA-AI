
package com.nexora.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Black = Color(0xFF090909)
private val Surface = Color(0xFF171717)
private val White = Color(0xFFF5F5F5)
private val Muted = Color(0xFF999999)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexoraApp()
        }
    }
}

@Composable
fun NexoraApp() {
    var message by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf<String>()) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black)
                .padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "NEXORA",
                        color = White,
                        fontSize = 27.sp
                    )
                    Text(
                        "ARTIFICIAL INTELLIGENCE",
                        color = Muted,
                        fontSize = 9.sp
                    )
                }

                TextButton(onClick = {}) {
                    Text("SETTINGS", color = White)
                }
            }

            Spacer(Modifier.height(35.dp))

            Text(
                "Beyond Intelligence.",
                color = White,
                fontSize = 25.sp
            )

            Text(
                "How can I help you today?",
                color = Muted,
                fontSize = 14.sp
            )

            Spacer(Modifier.height(25.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                messages.forEach {
                    Text(
                        it,
                        color = White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                Surface,
                                RoundedCornerShape(14.dp)
                            )
                            .padding(14.dp)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    placeholder = {
                        Text("Ask NEXORA anything...")
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = White,
                        unfocusedTextColor = White,
                        focusedBorderColor = White,
                        unfocusedBorderColor = Muted
                    )
                )

                Spacer(Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (message.isNotBlank()) {
                            messages = messages + message
                            message = ""
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = White,
                        contentColor = Black
                    )
                ) {
                    Text("SEND")
                }
            }
        }
    }
}
