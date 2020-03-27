import com.google.inject.Guice;
import com.google.inject.Injector;
import models.ResponseData;
import models.User;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import retrofit2.Response;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimpleTest {
    private ReqresServiceExecutor reqresServiceExecutor;

    @BeforeAll
    void getInjector() {
        Injector injector = Guice.createInjector(new DemoModule());
        reqresServiceExecutor = injector.getInstance(ReqresServiceExecutor.class);
    }

    @Test
    public void checkSecondUserExist() {
        Response<ResponseData> userData = reqresServiceExecutor.getUserDataById(2);
        assertThat(userData.code()).isEqualTo(200);
        assertThat(userData.body()).isNotNull();
        User requestedUser = userData.body().getUser();

        User testDataUser = null;
        try {
            testDataUser = JsonHandler.getUserFromJson();
        } catch (FileNotFoundException e) {
            Fail.fail("Cannot read user test data");
        }
        assertThat(testDataUser).isNotNull();

        assertThat(requestedUser).isEqualTo(testDataUser);
    }

    @Test
    public void checkInexistentUser() {
        Response<ResponseData> userData = reqresServiceExecutor.getUserDataById(23);
        assertThat(userData.code()).isEqualTo(404);
        assertThat(userData.message()).isEqualTo("Not Found");
    }
}