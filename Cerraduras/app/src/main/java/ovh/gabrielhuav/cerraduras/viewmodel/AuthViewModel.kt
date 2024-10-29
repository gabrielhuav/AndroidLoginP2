package ovh.gabrielhuav.cerraduras.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ovh.gabrielhuav.cerraduras.models.LoginCredentials
import ovh.gabrielhuav.cerraduras.network.ApiService
import ovh.gabrielhuav.cerraduras.network.RetrofitClient
import retrofit2.HttpException

class AuthViewModel : ViewModel() {

    // Estado que indica si el usuario ha iniciado sesión
    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun loginUser(credentials: LoginCredentials, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.login(credentials)
                if (response.isSuccessful) {
                    _isLoggedIn.value = true
                    onSuccess()
                } else {
                    _isLoggedIn.value = false
                    onError("Credenciales inválidas o error en el servidor")
                }
            } catch (e: HttpException) {
                _isLoggedIn.value = false
                onError("Error de red")
            } catch (e: Exception) {
                _isLoggedIn.value = false
                onError("Error desconocido: ${e.message}")
            }
        }
    }
}
