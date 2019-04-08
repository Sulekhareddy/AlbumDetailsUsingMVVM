package com.example.albumdetailsusingmvvm.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.albumdetailsusingmvvm.R;
import com.example.albumdetailsusingmvvm.model.Result;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.album_image)
    ImageView album_Image;
    @BindView(R.id.title)
    TextView title;

    private Context context;

    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void bind(Result result){
        String imageUrl = result.getUrl();
        title.setText(result.getTitle());
        setAlbumImage(album_Image, imageUrl, context);
    }

    private void setAlbumImage(ImageView albumImage, String imageUrl, Context context) {
        Glide.with(context)
                .load(imageUrl)
                .into(albumImage);

    }

}
