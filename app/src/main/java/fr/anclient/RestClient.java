package fr.anclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private AnApi api;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://assnat.hebus.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(AnApi.class);
    }


    public Call<List<Deputy>> listDeputies() {
        return api.listDeputies();
    }
}
