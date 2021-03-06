package pnt.co.edu.unisabana;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HerokuService {

    @FormUrlEncoded
    @POST("registroEst")
    Call<ResponseBody>registroEst(@Field("nombre") String nombre, @Field("apellido") String apellido, @Field("id") String id, @Field("email") String email, @Field("carrera") String carrera, @Field("contrasena") String contrasena);

    @FormUrlEncoded
    @POST("registroBib")
    Call<ResponseBody>registroBib(@Field("nombre")String nombre,@Field("apellido")String apellido, @Field("id")String id,@Field("email")String email,@Field("contrasena") String contrasena,@Field("telefono") String telefono,@Field("direccion") String direccion);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody>login(@Field("email") String email,@Field("contrasena") String contrasena);

    @FormUrlEncoded
    @POST("registroLib")
    Call<ResponseBody>registroLib(@Field("titulo") String titulo, @Field("autor") String autor, @Field ("resumen") String resumen, @Field ("unidades") int unidades, @Field("issn") String issn, @Field("keyword") String keywords);

    @FormUrlEncoded
    @POST("registroPres")
    Call<ResponseBody> registroPres(@Field ("issnPrestamo") String issnPrestamo, @Field ("fechaPrestamo") String fechaPrestamo, @Field ("idPrestamo") int idPrestamo);
}
