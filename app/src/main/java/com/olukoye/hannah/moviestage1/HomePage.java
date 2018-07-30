package com.olukoye.hannah.moviestage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MovieAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MovieAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);

    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public MovieViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
