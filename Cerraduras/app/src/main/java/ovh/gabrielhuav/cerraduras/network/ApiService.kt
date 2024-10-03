package ovh.gabrielhuav.cerraduras.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ovh.gabrielhuav.cerraduras.models.LoginCredentials
import ovh.gabrielhuav.cerraduras.models.User

interface ApiService {

    @POST("/auth/login")
    suspend fun login(@Body credentials: LoginCredentials): Response<ResponseBody>

    @POST("/auth/register")
    suspend fun registerUser(@Body user: User): Response<ResponseBody>
}
