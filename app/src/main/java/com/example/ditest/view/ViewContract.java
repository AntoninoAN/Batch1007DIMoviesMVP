package com.example.ditest.view;

import com.example.ditest.model.MovieResult;

import java.util.List;

public interface ViewContract {
    void filterQuery(String query);
    void initUI();
    void initNetworkCall();
    void initPresenter(); /*presenter=new*/
    void getError(String errorMessage);
    void getData(MovieResult dataSet);
}
