package com.olukoye.hannah.moviestage1;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by hannaholukoye on 30/07/2018.
 */
public interface RatedMoviesInterfaceApi {
    @GET("/movie/top_rated")
    void getTopRatedMovies(Callback<Movie.RatedMovieResult> rb);

}