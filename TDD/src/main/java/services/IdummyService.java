package services;

import models.JWTModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IdummyService {

    @POST("auth/login")
    Call<JWTModel> login(@Body JWTModel jwtModel);

}
