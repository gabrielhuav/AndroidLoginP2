package ovh.gabrielhuav.cerraduras.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ovh.gabrielhuav.cerraduras.models.LoginCredentials

interface ApiService {
    @POST("/login")
    suspend fun login(@Body credentials: LoginCredentials): Response<ResponseBody>
}
