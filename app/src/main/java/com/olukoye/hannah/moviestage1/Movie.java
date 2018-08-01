package com.olukoye.hannah.moviestage1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hannaholukoye on 30/07/2018.
 */

public class Movie {
    // To get image we use https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg


    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String description;
    private String title;
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("vote_average")
    private String rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {this.poster = poster;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public static class PopularMovieResult {
            private List<Movie> results;

            public List<Movie> getPopularResults() {
                return results;
            }
    }

    public static class RatedMovieResult {
        private List<Movie> results;

        public List<Movie> getRatedResults() {
            return results;
        }
    }

}
