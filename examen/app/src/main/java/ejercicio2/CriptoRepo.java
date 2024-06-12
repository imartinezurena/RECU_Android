package ejercicio2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CriptoRepo {
    @GET("api/cripto/{id}")
    Call<Cripto> getCriptoById(@Path("id") int id);
}
