package com.olukoye.hannah.moviestage1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by hannaholukoye on 30/07/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<HomePage.MovieViewHolder>
{
    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    public MovieAdapter(Context context)
    {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }


    @Override
    public HomePage.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.row_layout, parent, false);
        HomePage.MovieViewHolder viewHolder = new HomePage.MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HomePage.MovieViewHolder holder, int position)
    {
        final Movie movie = mMovieList.get(position);
        String image_path = mContext.getString(R.string.image_base_url);
        final String imageUrl = image_path + movie.getPoster();
        // This is how we use Picasso to load images from the internet.
        Picasso.with(mContext)
                .load(imageUrl)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Open Movie details", String.valueOf(movie.getDescription()));
                Intent openPoster = new Intent(mContext, PosterDetails.class);
                openPoster.putExtra("title", movie.getTitle());
                openPoster.putExtra("description",movie.getDescription());
                openPoster.putExtra("rating",movie.getRating());
                openPoster.putExtra("posterurl",imageUrl);
                mContext.startActivity(openPoster);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    public void setMovieList(List<Movie> movieList)
    {
        if(movieList != null) {
            this.mMovieList.clear();
            this.mMovieList.addAll(movieList);
            // The adapter needs to know that the data has changed. If we don't call this, app will crash.
            notifyDataSetChanged();
        }
    }
}
