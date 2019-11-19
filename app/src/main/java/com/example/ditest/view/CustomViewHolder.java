package com.example.ditest.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ditest.R;
import com.example.ditest.model.MovieDetail;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class CustomViewHolder extends
        RecyclerView.ViewHolder {

    @BindView(R.id.tv_item_genre)
    TextView tvItemGenre;
    @BindView(R.id.iv_item_poster)
    ImageView ivItemPoster;

    public CustomViewHolder(View itemView){
        super(itemView);
    }


    public void bind(MovieDetail movieDetail, UpdateToolbarImage listener) {
        tvItemGenre.setText(movieDetail.poster);
        Picasso.get().load(movieDetail.poster).into(ivItemPoster);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.updateAppBarImage();
            }
        });
    }
}
