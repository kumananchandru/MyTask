package com.mbrhe.mytask.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsModel {

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }

    @SerializedName("payload")
    List<DataModel> data;

    public class DataModel {

        @SerializedName("title")
        String title;
        @SerializedName("description")
        String description;
        @SerializedName("date")
        String date;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @SerializedName("image")
        String image;

        /*@BindingAdapter({ "avatar" })
        public void loadImage(ImageView imageView, String imageURL) {

            if (imageURL == null) {
                imageView.setImageDrawable(null);
            } else {
                Picasso.with(imageView.getContext())
                        .load(imageURL)
                        .into(imageView);
            }
        }*/

    }


}
