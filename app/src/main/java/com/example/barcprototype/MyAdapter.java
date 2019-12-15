package com.example.barcprototype;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;
    private int imageid;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView image;
        public MyViewHolder(@NonNull View v) {
            super(v);
            textView = v.findViewById(R.id.textView);
            image = v.findViewById(R.id.imageView);
        }

    }

    public MyAdapter(String[] myDataset, int imageid) {
        mDataset = myDataset;
        this.imageid = imageid;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        int image_id = imageid;
        final ListItem listItem = new ListItem(mDataset[position], image_id);
        holder.image.setImageResource(image_id);
        holder.textView.setText(mDataset[position]);
        holder.itemView.setBackgroundColor(listItem.isSelected() ? Color.CYAN: Color.WHITE);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem.setSelected(!listItem.isSelected());
                holder.itemView.setBackgroundColor(listItem.isSelected() ? Color.CYAN: Color.WHITE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;

    }



}
