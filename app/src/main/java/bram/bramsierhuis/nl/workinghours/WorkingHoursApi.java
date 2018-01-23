package bram.bramsierhuis.nl.workinghours;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.Call;

public interface WorkingHoursApi {
    String BASE_URL = "http://bramsierhuis.nl/WorkingHours/";

    @FormUrlEncoded
    @POST("register.php")
    Call<String> register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<String> login(
            @Field("username") String username,
            @Field("password") String password
    );

}