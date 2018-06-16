package com.example.admin.anqijd.View.Activity;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.WindowManager;

import com.example.admin.anqijd.Model.Bean.BannerBean;
import com.example.admin.anqijd.Model.Model;
import com.example.admin.anqijd.Presenter.BannerPresenter;
import com.example.admin.anqijd.R;
import com.example.admin.anqijd.View.Fragment.ClassiyFragment;
import com.example.admin.anqijd.View.Fragment.FindFragment;
import com.example.admin.anqijd.View.Fragment.HomeFragment;
import com.example.admin.anqijd.View.Fragment.MyFragment;
import com.example.admin.anqijd.View.Fragment.ShopFragment;
import com.example.admin.anqijd.View.IView;
import com.example.mybase.BaaseActivity;
import com.example.mybase.BaseModel;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaaseActivity<BannerPresenter>implements IView {

     private List<Fragment> list =  new ArrayList<>();
  @BindView(R.id.page)
    ViewPager pager;
   @BindView(R.id.bar)
    BottomBar bar;
   @Override
    protected void initView() {
       ButterKnife.bind(this);
    }

    @Override
    protected int bindLayoutid() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //半透明头部状态栏，底部导航栏   布局在状态栏，导航栏下方
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        }
        return R.layout.activity_main;

    }

    @Override
    protected BannerPresenter ininPresenter() {
        return new BannerPresenter();
    }

    @Override
    protected BaseModel initModel() {

        return new Model();
    }

    @Override
    protected void getdata() {

      initviewpager();
bar.setOnTabSelectListener(new OnTabSelectListener() {


   @Override
         public void onTabSelected(int tabId) {
               switch (tabId)
               {
                   case R.id.tab_home:
                       pager.setCurrentItem(0,false);
                       break;
                   case R.id.tab_flei:
                       pager.setCurrentItem(1,false);
                       break;
                   case R.id.tab_find:
                       pager.setCurrentItem(2,false);
                       break;
                   case R.id.tab_shop:
                       pager.setCurrentItem(3,false);
                       break;
                   case R.id.tab_My:
                       pager.setCurrentItem(4,false);
                       break;
               }
         }
     });


        presenter.getdata();
    }


    private void initviewpager() {
      list.add(new HomeFragment());
      list.add(new ClassiyFragment());
      list.add(new FindFragment());
      list.add(new ShopFragment());
      list.add(new MyFragment());
      pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
          @Override
          public Fragment getItem(int position) {
              return list.get(position);
          }

          @Override
          public int getCount() {
              return list.size();
          }
      });

      pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

          }

          @Override
          public void onPageSelected(int position) {
                   bar.selectTabAtPosition(position);
          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });

    }

    @Override
    public void sucess(BannerBean json) {
        Log.e("----------------",""+json.getData().get(0).getTitle());
      }
}
