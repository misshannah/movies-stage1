package com.olukoye.hannah.moviestage1;

import retrofit.Callback;
import retrofit.http.GET;


public interface RatedMoviesInterfaceApi {
    @GET("/movie/top_rated")
    void getTopRatedMovies(Callback<Movie.RatedMovieResult> rb);

}