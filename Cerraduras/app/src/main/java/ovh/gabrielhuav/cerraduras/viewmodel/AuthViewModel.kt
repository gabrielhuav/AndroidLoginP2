package ovh.gabrielhuav.cerraduras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ovh.gabrielhuav.cerraduras.models.LoginCredentials
import ovh.gabrielhuav.cerraduras.repository.AuthRepository
import ovh.gabrielhuav.cerraduras.models.User
class AuthViewModel : ViewModel() {

    private val authRepository = AuthRepository()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun loginUser(credentials: LoginCredentials, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = authRepository.loginUser(credentials)
                if (response.isSuccessful && response.body()?.string() == "Inicio de sesión exitoso") {
                    _isLoggedIn.value = true
                    onSuccess()
                } else {
                    onError("Credenciales inválidas o error en el servidor")
                }
            } catch (e: Exception) {
                onError(e.message ?: "Error desconocido")
            }
        }
    }

    fun registerUser(user: User, onSuccess: () -> Unit, onError: (String) -> Unit) {
            viewModelScope.launch {
                try {
                    val response = authRepository.registerUser(user)
                    if (response.isSuccessful) {
                        onSuccess()
                    } else {
                        onError("Registro fallido")
                    }
                } catch (e: Exception) {
                    onError(e.message ?: "Error desconocido")
                }
            }
        }
}
