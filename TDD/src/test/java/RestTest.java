import models.JWTModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import services.IdummyService;
import utils.Api;

import java.io.IOException;

public class RestTest {

    @Test
    public void loginTest() throws IOException {

        JWTModel jwtModel = new JWTModel();
        jwtModel.setUsername("kminchelle");
        jwtModel.setPassword("0lelplR");

        IdummyService service = Api.connect().create(IdummyService.class);
        Response<JWTModel> response = service.login(jwtModel).execute();

        Assertions.assertAll(
                () -> Assertions.assertEquals(response.code(), 200),
                () -> Assertions.assertNotNull(response.body()),
                () -> Assertions.assertNotEquals(response.body().getToken(), "")
        );

    }

}
