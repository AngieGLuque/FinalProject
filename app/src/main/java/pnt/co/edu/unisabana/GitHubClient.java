package pnt.co.edu.unisabana;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET
    Call<List<GitHubRepo>> reposForUser(@Path("user")String user);
        
}
