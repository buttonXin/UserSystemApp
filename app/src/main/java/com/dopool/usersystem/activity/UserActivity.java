package com.dopool.usersystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.dopool.usersystem.R;
import com.dopool.usersystem.activity.DeviceManage.DeviceActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/21 0021.
 */

public class UserActivity extends BaseActivity {

    @BindView(R.id.btn_account)
    Button mAccount;
    @BindView(R.id.btn_interest)
    Button mInterest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }
    /**
     *我的设备
     */
    @OnClick(R.id.btn_account)
    public void myAccount(){
        startActivity(new Intent(this , DeviceActivity.class));
    }
    /**
     * 我的兴趣
     */
    @OnClick(R.id.btn_interest)
    public void myInterest(){
        startActivity(new Intent(this  , InterestActivity.class));
    }

}
