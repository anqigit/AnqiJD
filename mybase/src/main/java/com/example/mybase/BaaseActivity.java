package com.example.mybase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author:Created by WangZhiQiang on 2018-6-14.
 */
public  abstract class BaaseActivity<P extends BasePresenter>   extends AppCompatActivity implements IBaseView {

    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(bindLayoutid());
         initView();
          presenter=ininPresenter();
         if(presenter!=null){
                presenter.attch(initModel(),this);
         }
         getdata();
    }

    protected abstract void initView();

    protected abstract int bindLayoutid();

    protected  abstract P ininPresenter();

    protected  abstract BaseModel initModel();

    protected  abstract void getdata();

    @Override
    public void Sucess(String msg) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
