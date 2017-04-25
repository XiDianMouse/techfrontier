package com.techfrontier.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.techfrontier.R;

/**
 * @auther gbh
 * Created on 2017/4/25.
 */

public abstract class BaseActionBarActivity extends ActionBarActivity {
    protected Toolbar mToolbar;

    @Override
    protected final void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        setupToolbar();
        initWidgets();
        afterOnCreate();
    }

    protected abstract  int getContentViewResId();

    protected void setupToolbar(){
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected  void initWidgets(){

    }

    protected  void afterOnCreate(){

    }
}
