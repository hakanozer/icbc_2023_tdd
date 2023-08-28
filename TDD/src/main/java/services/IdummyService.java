package services;

import models.JWTModel;
import models.ProductModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IdummyService {

    @POST("auth/login")
    Call<JWTModel> login(@Body JWTModel jwtModel);

    @GET("products/{id}")
    Call<ProductModel> singleProduct(@Path("id") int id );

}
