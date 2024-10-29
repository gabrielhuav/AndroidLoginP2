package ovh.gabrielhuav.cerraduras

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    // Método de logout para el botón
    fun logout(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish() // Cierra DashboardActivity
    }
}
