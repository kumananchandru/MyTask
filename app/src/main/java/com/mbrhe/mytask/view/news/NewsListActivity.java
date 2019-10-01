package com.mbrhe.mytask.view.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mbrhe.mytask.R;
import com.mbrhe.mytask.model.UserModel;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_list_activity);

        UserModel user = (UserModel) getIntent().getSerializableExtra("USER_OBJ");
        Log.e("News", "---" + user.getName());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}
