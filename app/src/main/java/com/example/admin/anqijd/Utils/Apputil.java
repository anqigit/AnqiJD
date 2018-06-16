package com.example.admin.anqijd.Utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * author:Created by WangZhiQiang on 2018-6-16.
 */
public class Apputil {
    public static int screenWidth(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return  metrics.widthPixels;
    }
}
