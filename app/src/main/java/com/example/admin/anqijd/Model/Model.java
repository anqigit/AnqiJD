package com.example.admin.anqijd.Model;

import com.example.admin.anqijd.Model.Bean.BannerBean;
import com.example.admin.anqijd.Utils.Ret;
import com.example.mybase.BaseModel;

import retrofit2.Retrofit;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author:Created by WangZhiQiang on 2018-6-14.
 */
public class Model extends BaseModel {
    public void getdata(final  Data data){
        Retrofit retrofit = Ret.getInstance().getRetrofit();
        Subscription subscribe = retrofit.create(Api.class).getCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                         data.sucess(bannerBean);
                    }
                });

    }

    public  interface Data{
         void sucess(BannerBean json);
    }

}
