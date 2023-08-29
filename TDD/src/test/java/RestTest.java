import models.JWTModel;
import models.ProductModel;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit2.Call;
import retrofit2.Response;
import services.IdummyService;
import utils.Api;
import utils.AppEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RestTest {

    IdummyService service;

    @BeforeAll
    public void beforeAll() {
        service = Api.connect().create(IdummyService.class);
    }

    @ParameterizedTest
    @MethodSource("users")
    @Tag(Config.rest)
    public void loginTest(JWTModel jwtModel) throws IOException {

        Response<JWTModel> response = service.login(jwtModel).execute();
        System.out.println( response.body().getToken() );
        Assertions.assertAll(
                () -> Assertions.assertEquals(response.code(), 200),
                () -> Assertions.assertNotNull(response.body()),
                () -> Assertions.assertNotEquals(response.body().getToken(), "")
        );

    }

    // parameter
    @ParameterizedTest
    @ValueSource(strings = {"İstanbul", "Ankara", "Bursa", "Adana"})
    public void testStringValues( String item ) {
        System.out.println( item );
    }


    static List<JWTModel> users() {
        List<JWTModel> ls = new ArrayList<>();

        JWTModel j1 = new JWTModel();
        j1.setUsername("atuny0");
        j1.setPassword("9uQFF1Lh");
        ls.add(j1);

        JWTModel j2 = new JWTModel();
        j2.setUsername("hbingley1");
        j2.setPassword("CQutx25i8r");
        ls.add(j2);

        JWTModel j3 = new JWTModel();
        j3.setUsername("rshawe2");
        j3.setPassword("OWsTbMUgFc");
        ls.add(j3);

        return ls;
    }

    @ParameterizedTest
    @EnumSource(AppEnum.class)
    void testEnumKeys( AppEnum appEnum ) {
        System.out.println("appEnum: "+ appEnum);
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/data.csv", numLinesToSkip = 0)
    void csvRead(int id, String name, String email, String password) {
        System.out.println( id + " - " + name + " - " + email  + " - " + password );
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,900})
    @Tag(Config.rest)
    @Disabled
    public void singleTest(int id) throws IOException {
        Call<ProductModel> modelCall = service.singleProduct(id);
        Response<ProductModel> modelResponse = modelCall.execute();
        Assertions.assertAll(
                () -> Assertions.assertEquals(modelResponse.code(), 200, "HttpStatus Code Not 200"),
                () -> Assertions.assertNotNull(modelResponse.body(), "ProductModel Null"),
                () -> Assertions.assertEquals( modelResponse.body().getImages().size() > 1, true, "This product images 1" )
        );
    }

    @Test
    @EnabledIf("status")
    public void ifTest() {
        System.out.println("ifTest call");
    }

    public boolean status() {
        return service != null ? false : false;
    }

}
