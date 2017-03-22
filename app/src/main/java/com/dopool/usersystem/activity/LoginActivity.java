package com.dopool.usersystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.dopool.usersystem.R;
import com.dopool.usersystem.ui.SecurityButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btn_code)
    SecurityButton mBtnCode;//验证码按钮
    @BindView(R.id.btn_login)
    Button mLogin;//登录按钮
    @BindView(R.id.edit_code)
    EditText mEditCode;//验证码输入框
    @BindView(R.id.edit_phone)
    EditText mPhone;//手机号输入框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    /**
     * 点击发送验证码
     */
    @OnClick(R.id.btn_code)
    public void getAuthCode(){
        String phone = mPhone.getText().toString().trim();

        showToast("网路请求start" + phone);
        mBtnCode.start();
      /*  OkHttp.getJson("", new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String response, int id) {

            }
        });*/
    }
    /**
     * 点击登录
     */
    @OnClick(R.id.btn_login)
    public void login(){
        if ("1234".equals(mEditCode.getText().toString().trim()) ){
            showToast("成功");
            startActivity(new Intent(this , UserActivity.class));
            finish();

        }else {
            showToast("验证码不正确");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
