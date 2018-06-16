package com.example.admin.anqijd.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.anqijd.Utils.Apputil;

/**
 * author:Created by WangZhiQiang on 2018-6-16.
 */
public class FlowLayout extends ViewGroup{
    public FlowLayout(Context context) {
        super(context);
    }
    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //onMeasure()方法，用于View以及自身的测量，是本次自定义控件需要重写的重要的方法之一，
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height=0;
        int width=0;
        int child=getChildCount();
        for (int i=0;i<child;i++){
            View view=getChildAt(i);
            height+=view.getMeasuredHeight();
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
        }
        width= Apputil.screenWidth(getContext());
        setMeasuredDimension(width,height);
    }
    //onLayout()方法，主要对View进行布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
       int le=0;
       int ri=0;
       int child=getChildCount();
       for(int i=0;i<child;i++){
           View view=getChildAt(i);
           view.layout(le,ri,le+view.getMeasuredWidth(),ri+view.getMeasuredHeight());
           le+=view.getMeasuredWidth();
           ri+=view.getMeasuredHeight();
           if(le+view.getMeasuredWidth()>Apputil.screenWidth(getContext())){
               le=0;
         }
}
}
}