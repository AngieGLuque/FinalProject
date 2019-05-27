package pnt.co.edu.unisabana;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HerokuService {

    @FormUrlEncoded
    @POST("registro")
    Call<ResponseBody>registro(@Field("nombre")String nombre,);
}