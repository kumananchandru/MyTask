package com.mbrhe.mytask.view.news;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbrhe.mytask.R;
import com.mbrhe.mytask.model.NewsModel;
import com.mbrhe.mytask.viewModel.NewsListViewModel;

import java.util.ArrayList;
import java.util.List;


public class NewsListFragment extends Fragment {

    private NewsListViewModel mViewModel;
    private List<NewsModel.DataModel> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewsAdapter mAdapter;
    private SwipeRefreshLayout swipeContainer;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.news_list_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        swipeContainer = view.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync();
            }
        });

        mAdapter = new NewsAdapter(newsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void fetchTimelineAsync() {
        mViewModel = ViewModelProviders.of(this).get(NewsListViewModel.class);
        mViewModel.init();
        newsList.clear();
        mViewModel.getNews().observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(@Nullable NewsModel newsModels) {

                newsList.addAll(newsModels.getData());
                mAdapter.notifyDataSetChanged();
            }
        });
        swipeContainer.setRefreshing(false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fetchTimelineAsync();
        }

}
