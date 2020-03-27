import com.google.gson.Gson;
import models.ResponseData;
import models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonHandler {

    public static User getUserFromJson() throws FileNotFoundException {
        Gson gson = new Gson();
        ResponseData responseData = gson.fromJson(new FileReader("C:\\Users\\a.generalova\\IdeaProjects\\untitled\\src\\test\\resources\\userTestData.json"), ResponseData.class);
        User user = responseData.getUser();
        return user;
    }
}
