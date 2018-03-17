package com.example.administrator.slopedisplacement.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.slopedisplacement.R;

/**
 * 加载图片工具类
 */

public class LoadImgUtils {
    public static void loadImg(Activity activity, String imgUrl, ImageView imageView) {
        Glide.with(activity)
                .load(imgUrl)//拿到头像本地存放路径
                .error(R.mipmap.ic_launcher)//失败默认
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
                .skipMemoryCache(true)
                .into(imageView);
    }
}
