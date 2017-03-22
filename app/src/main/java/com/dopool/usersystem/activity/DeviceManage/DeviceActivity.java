package com.dopool.usersystem.activity.DeviceManage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.dopool.usersystem.R;
import com.dopool.usersystem.activity.BaseActivity;
import com.dopool.usersystem.adapter.DeviceAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我的设备
 * Created by Administrator on 2017/3/21 0021.
 */

public class DeviceActivity extends BaseActivity {

    private static final int REFRESH_COMPLETE = 123;
    private ListView mListview;
    private XRefreshView xRefreshView;
    private DeviceAdapter mAdapter;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("Java", "Javascript", "C++", "Ruby", "Json",
            "HTML"));

    private Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    lastRefreshTime = xRefreshView.getLastRefreshTime();
                    mAdapter.addData(mDatas);
                    xRefreshView.stopRefresh();
                    xRefreshView.stopLoadMore();
                    break;
            }
        }
    };
    private long lastRefreshTime=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        initView();
    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.id_listview_device);
        xRefreshView = (XRefreshView) findViewById(R.id.id_xrefresh_device);
        mAdapter = new DeviceAdapter(this);
        mAdapter.addData(mDatas);
        mListview.setAdapter(mAdapter);

        // 设置是否可以下拉刷新
        xRefreshView.setPullRefreshEnable(true);
        // 设置是否可以上拉加载
        xRefreshView.setPullLoadEnable(true);
        // 设置上次刷新的时间
        xRefreshView.restoreLastRefreshTime(lastRefreshTime);
        // 设置时候可以自动刷新
        xRefreshView.setAutoRefresh(false);

        xRefreshView.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh() {
                Toast.makeText(DeviceActivity.this, "bbbbb", Toast.LENGTH_SHORT).show();
                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                Toast.makeText(DeviceActivity.this, "aaaaaaaa", Toast.LENGTH_SHORT).show();
                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
            }
        });

        mListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });

    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.id_addbtn_device:
                startActivityForResult(new Intent(DeviceActivity.this, QRCodeActivity.class), 0);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                Bundle result = data.getExtras();
                String qrtext = result.getString("result");
                Toast.makeText(this, qrtext, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
