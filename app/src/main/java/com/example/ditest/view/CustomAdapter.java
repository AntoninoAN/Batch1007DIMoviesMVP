package com.example.ditest.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ditest.R;
import com.example.ditest.model.MovieResult;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {

    private MovieResult dataSet;
    private UpdateToolbarImage listener;

    public void setDataSet(MovieResult dataSet){
        this.dataSet = dataSet;
    }


    public void setListener(UpdateToolbarImage listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext())
                    .inflate(
                            R.layout.item_layout,
                            parent,
                            false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(dataSet.data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.data.size() : 0;
    }
}
