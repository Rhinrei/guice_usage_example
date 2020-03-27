import models.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReqresRetrofit {
    @GET("/api/users/{id}")
    Call<ResponseData> getUser(@Path("id") int id);
}
