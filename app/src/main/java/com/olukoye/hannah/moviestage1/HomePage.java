package com.olukoye.hannah.moviestage1;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.olukoye.hannah.moviestage1.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomePage extends AppCompatActivity {
    MovieAdapter mAdapter;
    ActivityHomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isOnline();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MovieAdapter(this);
        binding.recyclerView.setAdapter(mAdapter);
        final List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.movie_url_base))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", getString(R.string.movie_api_key));
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        MoviesInterfaceApi service = restAdapter.create(MoviesInterfaceApi.class);
        service.getPopularMovies(new Callback<Movie.PopularMovieResult>() {
            @Override
            public void success(Movie.PopularMovieResult movieResult, Response response) {
                mAdapter.setMovieList(movieResult.getPopularResults());
                Log.i("output", movies.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }
    //To verify internet connection is available
    public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);
            Toast.makeText(getApplicationContext(), "Connected to the Internet!", Toast.LENGTH_SHORT).show();

            return reachable;
        } catch (Exception e) {

            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Check Internet connection!", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MovieViewHolder(View itemView)

        {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
