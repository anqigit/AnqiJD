package com.example.admin.anqijd.View.Fragment;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.anqijd.R;
import com.example.admin.anqijd.Utils.Apputil;
import com.example.mybase.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by WangZhiQiang on 2018-6-15.
 */
public class HomeFragment extends BaseFragment implements  View.OnClickListener {
   @BindView(R.id.ss)
    TextView sou;
   @BindView(R.id.edit)
    EditText ed;

   @Override
    protected int layout() {
           return R.layout.home_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this,getView());
    }

    @Override
    protected void initdata() {
           sou.setOnClickListener(this);
    }



    //点击搜索框将输入内容添加到流式布局
    @Override
    public void onClick(View view) {



                int width= Apputil.screenWidth(getContext());
                String s = ed.getText().toString();
                TextView textView = new TextView(getContext());
                textView.setText(s);
                textView.setBackgroundColor(Color.RED);

                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"translationX",(width-width/2),0);

                objectAnimator.setDuration(3000);
                objectAnimator.start();
                textView.setGravity(Gravity.CENTER);
                //two.addView(textView);
                ViewGroup.LayoutParams params = textView.getLayoutParams();
                params.width=width/2;
                params.height=70;
                textView.setLayoutParams(params);
            }

}
