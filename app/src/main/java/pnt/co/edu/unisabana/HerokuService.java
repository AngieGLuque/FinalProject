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
    @POST("registroEst")
    Call<ResponseBody>registroEst(@Field("nombre")String nombre,@Field("apellido")String apellido,@Field("id")String id,@Field("email")String email, @Field("carrera")String carrera,@Field("contrasena") String contrasena);

    @FormUrlEncoded
    @POST("registroBib")
    Call<ResponseBody>registroBib(@Field("nombre")String nombre,@Field("apellido")String apellido, @Field("id")String id,@Field("email")String email,@Field("contrasena") String contrasena,@Field("telefono") String telefono,@Field("direccion") String direccion);

    @FormUrlEncoded
    @POST("datos")
    Call<ResponseBody>datos(@Field("email") String email);
}