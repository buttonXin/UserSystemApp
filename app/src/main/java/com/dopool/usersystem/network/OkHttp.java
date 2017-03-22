package com.dopool.usersystem.network;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public class OkHttp {

    /**
     * 获取数据
     * @param url
     * @param callback
     */
    public static void getJson(String url , Callback callback){
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(callback);

    }
}
