package com.example.covidapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    List<Post> postlist;
    Context context;

    public PostAdapter(List<Post> postlist, Context context) {
        this.postlist = postlist;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postlist.get(position);
        holder.cases.setText(post.getUpdated());
        holder.deaths.setText(post.getDeaths());
        holder.recovery.setText(post.getRecovered());
    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView  cases,deaths,recovery;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            cases = itemView.findViewById(R.id.JmlhCase);
            deaths = itemView.findViewById(R.id.JmlhDeath);
            recovery = itemView.findViewById(R.id.JmlhRecovered);

        }
    }
}
