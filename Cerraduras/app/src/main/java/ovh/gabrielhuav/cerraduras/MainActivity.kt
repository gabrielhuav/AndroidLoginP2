package ovh.gabrielhuav.cerraduras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ovh.gabrielhuav.cerraduras.screens.DashboardScreen
import ovh.gabrielhuav.cerraduras.screens.LoginScreen
import ovh.gabrielhuav.cerraduras.ui.theme.CerradurasTheme
import ovh.gabrielhuav.cerraduras.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CerradurasTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp(authViewModel: AuthViewModel = viewModel()) {
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    if (isLoggedIn) {
        DashboardScreen()
    } else {
        LoginScreen(authViewModel) {
            // Redirigir al Dashboard al iniciar sesión
        }
    }
}
