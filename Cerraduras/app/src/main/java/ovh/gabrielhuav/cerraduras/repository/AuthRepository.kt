package ovh.gabrielhuav.cerraduras.repository

import ovh.gabrielhuav.cerraduras.models.LoginCredentials
import ovh.gabrielhuav.cerraduras.models.User
import ovh.gabrielhuav.cerraduras.network.RetrofitClient
import retrofit2.Response
import okhttp3.ResponseBody

class AuthRepository {

    suspend fun loginUser(credentials: LoginCredentials): Response<ResponseBody> {
        return RetrofitClient.apiService.login(credentials)
    }
}
