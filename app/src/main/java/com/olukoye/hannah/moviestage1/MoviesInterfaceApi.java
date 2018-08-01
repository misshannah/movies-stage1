package com.olukoye.hannah.moviestage1;

import retrofit.Callback;
import retrofit.http.GET;


public interface MoviesInterfaceApi {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.PopularMovieResult> cb);

}