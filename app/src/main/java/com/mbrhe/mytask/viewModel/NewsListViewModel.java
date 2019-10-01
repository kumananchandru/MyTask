package com.mbrhe.mytask.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.mbrhe.mytask.model.NewsModel;
import com.mbrhe.mytask.repository.NewsRepository;
import com.squareup.picasso.Picasso;

public class NewsListViewModel extends ViewModel {

    private MutableLiveData<NewsModel> data;
    private NewsRepository newsModel;

    public NewsListViewModel() {
        newsModel = new NewsRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = newsModel.getNews();
    }

    public MutableLiveData<NewsModel> getNews() {
        return this.data;
    }

    /*@BindingAdapter("bind:image")
    public static void loadImage(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageDrawable(null);
        } else {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }*/

}
