package com.yp.countriesapp.service;

import com.yp.countriesapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieDataService {
    @GET("3/movie/now_playing")
    Call<MovieResponse> getMovies(@Query("api_key") String apikey, @Query("language") String language, @Query("page") String page );
}
