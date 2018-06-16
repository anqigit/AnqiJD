package com.example.mybase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author:Created by WangZhiQiang on 2018-6-16.
 */
public abstract class BaseFragment extends Fragment implements IBaseView{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

          View view=inflater.inflate(layout(),container,false);
            initView();
            initdata();
          return  view;
    }
    protected  abstract  int layout();

    protected  abstract void initView();

    protected  abstract  void initdata();



    @Override
    public void Sucess(String msg) {

    }
}
