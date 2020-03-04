package com.example.marvel.view.marvel_details;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel.R;
import com.example.marvel.models.Item;
import com.example.marvel.view.marvel_characters.CharactersAdapter;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class ThumbnailsAdapter  extends RecyclerView.Adapter<ThumbnailsAdapter.ViewHolder>  {

    private LayoutInflater mInflater;
    private ArrayList<Item> items;
    private Context context;

    public ThumbnailsAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.items = items;

    }
    /**
     *inflates the cell layout from xml when needed
     */
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_character_detail, parent, false);
        return new ViewHolder(view);
    }

    /**
     *binds the data to the view in each cell
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Item item = items.get(position);
        holder.name.setText(item.getName());
        Glide.with(context)
                .load(item.getThumbnail().getPath()+"/portrait_small"+"."+item.getThumbnail().getExtension())
                .into(holder.image);



    }
    /**
     *total number of cells
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     *stores and recycles views as they are scrolled off screen
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);


        }
    }
}
