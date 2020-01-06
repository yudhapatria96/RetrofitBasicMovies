package com.yp.countriesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yp.countriesapp.R;
import com.yp.countriesapp.model.MovieResponse;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private ArrayList<MovieResponse.Result> moviesList;

    public MoviesAdapter(ArrayList<MovieResponse.Result> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_movies, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        holder.tvMoviesName.setText(moviesList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        TextView tvMoviesName;
        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMoviesName = itemView.findViewById(R.id.tv_movies_name);
        }
    }
}
