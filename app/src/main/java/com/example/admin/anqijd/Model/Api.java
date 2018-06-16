package com.example.admin.anqijd.Model;


import com.example.admin.anqijd.Model.Bean.BannerBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * author:Created by WangZhiQiang on 2018-6-14.
 */
public interface Api {
    @GET("ad/getAd")
    Observable<BannerBean> getCall();
}
