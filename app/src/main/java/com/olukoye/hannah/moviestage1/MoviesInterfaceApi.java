package com.olukoye.hannah.moviestage1;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by hannaholukoye on 30/07/2018.
 */
public interface MoviesInterfaceApi {
    @GET("/movie/popular")
    void getPopularMovies(Callback<Movie.PopularMovieResult> cb);
}