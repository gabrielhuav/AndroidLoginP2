package ovh.gabrielhuav.cerraduras.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ovh.gabrielhuav.cerraduras.models.Role
import ovh.gabrielhuav.cerraduras.models.User
import ovh.gabrielhuav.cerraduras.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(authViewModel: AuthViewModel = viewModel()) {
    var nombre by remember { mutableStateOf("") }
    var apellidoP by remember { mutableStateOf("") }
    var apellidoM by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = apellidoP, onValueChange = { apellidoP = it }, label = { Text("Apellido Paterno") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = apellidoM, onValueChange = { apellidoM = it }, label = { Text("Apellido Materno") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = correo, onValueChange = { correo = it }, label = { Text("Correo Electrónico") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = username, onValueChange = { username = it }, label = { Text("Nombre de Usuario") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val user = User(nombre, apellidoP, apellidoM, correo, username, password, 30, "Masculino", listOf(Role("ROLE_USER")))
            authViewModel.registerUser(user, {
                errorMessage = "Registro exitoso"
            }, {
                errorMessage = it
            })
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Registrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}
