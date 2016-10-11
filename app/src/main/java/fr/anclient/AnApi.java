package fr.anclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnApi {
    @GET("deputy")
    Call<List<Deputy>> listDeputies();
}
