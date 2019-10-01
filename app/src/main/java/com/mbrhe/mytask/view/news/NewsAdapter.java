package com.mbrhe.mytask.view.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbrhe.mytask.R;
import com.mbrhe.mytask.model.NewsModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsModel.DataModel> newsList;

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView desc;
        public TextView dateTv;

        public NewsViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.nameTv);
            desc = view.findViewById(R.id.descriptionTv);
            dateTv = view.findViewById(R.id.dateTv);
        }
    }

    public NewsAdapter(List<NewsModel.DataModel> newsList) {
        this.newsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        /*NewsItemBinding newsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.news_item, parent, false);*/
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

//        return new NewsViewHolder(newsItemBinding);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        NewsModel.DataModel news = newsList.get(position);
        holder.name.setText(news.getTitle());
        holder.desc.setText(news.getDescription());
        holder.dateTv.setText(news.getDate());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}