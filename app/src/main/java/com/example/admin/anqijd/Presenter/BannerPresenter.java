package com.example.admin.anqijd.Presenter;

import com.example.admin.anqijd.Model.Bean.BannerBean;
import com.example.admin.anqijd.Model.Model;
import com.example.admin.anqijd.View.IView;
import com.example.mybase.BasePresenter;

/**
 * author:Created by WangZhiQiang on 2018-6-14.
 */
public class BannerPresenter  extends BasePresenter<Model,IView>{

      public void getdata(){
          model.getdata(new Model.Data() {
              @Override
              public void sucess(BannerBean json) {
                  view.sucess(json);
              }
          });
      }
}
