package pnt.co.edu.unisabana;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static  Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://github.com/AngieGLuque/FinalProject/tree/master/app/src/main/java/pnt/co/edu/unisabana")
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();

    public static GitHubClient createService(){
        return retrofit.create(GitHubClient.class);
    }
}
