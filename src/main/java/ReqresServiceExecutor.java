import com.google.inject.Inject;
import models.ResponseData;
import org.assertj.core.api.Fail;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ReqresServiceExecutor {
    private ReqresRequestHandler requestHandler;

    @Inject
    public ReqresServiceExecutor(ReqresRequestHandler reqresRequestHandler){
        this.requestHandler = reqresRequestHandler;
    }

    public Response<ResponseData> getUserDataById( int id) {
        ReqresRetrofit service = requestHandler.getRetrofitService();
        Call<ResponseData> userCallSync = service.getUser(id);
        Response<ResponseData> userData = null;
        try {
            userData = userCallSync.execute();
        } catch (IOException e) {
            Fail.fail("User data request execution failed");
        }
        assertThat(userData).isNotNull();
        return userData;
    }
}
