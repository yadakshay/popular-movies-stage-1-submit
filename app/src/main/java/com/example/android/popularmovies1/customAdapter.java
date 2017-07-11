package com.example.android.popularmovies1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.android.popularmovies1.MainActivity.POSTER_BASE_URL;

/**
 * Created by Akshay on 09-07-2017.
 */

public class customAdapter extends ArrayAdapter<movieDetails> {

    //private static String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500";

    public customAdapter(Context context, ArrayList<movieDetails> movieList){
        super(context, 0, movieList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        movieDetails currentMovie = getItem(position);

        ImageView movieImage = (ImageView) gridItemView.findViewById(R.id.moviePosterHolder);

        String imageID = currentMovie.getImagePath();
        String imagePath = getImagePath(imageID);

        Picasso.with(getContext()).load(imagePath).into(movieImage);

        return gridItemView;
    }

    private String getImagePath(String imageId){
        String imagePath = POSTER_BASE_URL + imageId;
        return imagePath;
    }
}
