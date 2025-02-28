package com.example.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme
import com.example.hellocompose.ui.theme.Pink40
import com.example.hellocompose.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationForm(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegistrationForm(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // State untuk input form
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val phone = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val address = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier.fillMaxWidth().padding(16.dp)) {
        // Input Nama
        Text(text = "Nama", modifier = Modifier.padding(4.dp))
        TextField(value = name.value, onValueChange = { name.value = it },
            modifier = Modifier.fillMaxWidth().padding(4.dp))

        // Input Username
        Text(text = "Username", modifier = Modifier.padding(4.dp))
        TextField(value = username.value, onValueChange = { username.value = it },
            modifier = Modifier.fillMaxWidth().padding(4.dp))

        // Input Nomor Telepon
        Text(text = "Nomor Telepon", modifier = Modifier.padding(4.dp))
        TextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        )

        // Input Email
        Text(text = "Email", modifier = Modifier.padding(4.dp))
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        )

        // Input Alamat Rumah
        Text(text = "Alamat Rumah", modifier = Modifier.padding(4.dp))
        TextField(value = address.value, onValueChange = { address.value = it },
            modifier = Modifier.fillMaxWidth().padding(4.dp))

        // Tombol Simpan dan Reset
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (name.value.text.isNotEmpty() && username.value.text.isNotEmpty() &&
                        phone.value.text.isNotEmpty() && email.value.text.isNotEmpty() &&
                        address.value.text.isNotEmpty()
                    ) {
                        Toast.makeText(context, "Halo, ${name.value.text}", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Semua inputan harus diisi", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Purple80, contentColor = Color.White)
            ) {
                Text(text = "Simpan", style = TextStyle(fontSize = 18.sp), modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    name.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    phone.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    address.value = TextFieldValue("")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Pink40, contentColor = Color.White)
            ) {
                Text(text = "Reset", style = TextStyle(fontSize = 18.sp), modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForm() {
    HelloComposeTheme {
        RegistrationForm()
    }
}
