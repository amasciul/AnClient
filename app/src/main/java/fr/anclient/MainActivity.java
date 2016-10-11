package fr.anclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<List<Deputy>> {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RestClient client = new RestClient();
    private DeputyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        adapter = new DeputyAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        client.listDeputies().enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Deputy>> call, Response<List<Deputy>> response) {
        if (response.isSuccessful()) {
            adapter.setDeputies(response.body());
        } else {
            Log.e(TAG, "Error fetching deputies : " + response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Deputy>> call, Throwable t) {
        Log.e(TAG, "Error fetching deputies", t);
    }
}
