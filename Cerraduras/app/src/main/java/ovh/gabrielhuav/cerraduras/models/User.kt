package ovh.gabrielhuav.cerraduras.models

data class User(
    val nombre: String,
    val apellidoP: String,
    val apellidoM: String,
    val correo: String,
    val username: String,
    val password: String,
    val edad: Int,
    val genero: String,
    val roles: List<Role>
)
