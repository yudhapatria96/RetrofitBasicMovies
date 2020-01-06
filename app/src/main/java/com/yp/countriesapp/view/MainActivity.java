package com.yp.countriesapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.yp.countriesapp.R;
import com.yp.countriesapp.adapter.MoviesAdapter;
import com.yp.countriesapp.model.MovieResponse;
import com.yp.countriesapp.service.GetMovieDataService;
import com.yp.countriesapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String key= "510b3c8f14330962f06858164ec2078a";
    String language = "en-US";
    String page = "1";
    private MovieResponse movieResponse;
    private ArrayList<MovieResponse.Result> results;
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        getMovies();
    }

    public Object getMovies() {

        GetMovieDataService getMovieDataService = RetrofitInstance.getService();
        Call<MovieResponse> call = getMovieDataService.getMovies(key, language, page);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();

                if(movieResponse != null && movieResponse.getResults() != null){
                    results = (ArrayList<MovieResponse.Result>) movieResponse.getResults();
//                    for(MovieResponse.Result r: results) {
//                        Log.d("berhasil hore", r.getTitle().toString());
//                    }
                    viewData();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return results;
    }

    private void viewData() {
        recyclerView=(RecyclerView) findViewById(R.id.rv_movies);
        moviesAdapter= new MoviesAdapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(moviesAdapter);
    }
}
