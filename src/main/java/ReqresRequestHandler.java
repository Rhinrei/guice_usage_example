import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqresRequestHandler implements RequestHandler {
    public ReqresRetrofit getRetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReqresRetrofit service = retrofit.create(ReqresRetrofit.class);
        return service;
    }
}
