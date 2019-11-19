package com.example.ditest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ditest.R;
import com.example.ditest.di.CustomApplication;
import com.example.ditest.model.MovieResult;
import com.example.ditest.model.Network;
import com.example.ditest.presenter.Presenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity
        implements ViewContract {
    private static final String TAG = "MainActivity";
    @Inject
    Network network;
    //todo inject the pojo module
    @Inject
    Presenter presenter;
    //todo inject SQLite
    @Inject
    CustomAdapter adapter;
    @Inject
    GridLayoutManager layoutManager;
    //todo inject Adapter  adapter = new CustomA()

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomApplication.getComponent(this).inject(this);
        initUI();
        initPresenter();
        initNetworkCall();
    }

    @Override
    public void filterQuery(String query) {

    }

    @Override
    public void initUI() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //todo db.query
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initNetworkCall() {
        presenter.initNetworkCall();
    }

    @Override
    public void initPresenter() {
        presenter.initView(this);
    }

    @Override
    public void getError(String errorMessage) {

    }

    @Override
    public void getData(MovieResult dataSet) {
        Log.d(TAG, "getData: "+ dataSet.data.size());
        adapter.setDataSet(dataSet);
    }
}
