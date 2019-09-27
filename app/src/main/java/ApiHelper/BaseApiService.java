package ApiHelper;


import Models.DataDivisi;
import Models.DataRegister;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService
{
    @FormUrlEncoded
    @POST("register")
    Call<DataRegister> registerRequest(@Field("nik") String nik,
                                       @Field("email") String email,
                                       @Field("name") String name,
                                       @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("nik") String nik,
                                    @Field("password") String password);


    @FormUrlEncoded
    @POST("divisi")
    Call<DataDivisi> saveDivisi(@Field("nama") String nama);

    @PATCH("divisi/{id}")
    Call<DataDivisi> updateDivisi(@Path("id") int id, @Body DataDivisi nama);


}
