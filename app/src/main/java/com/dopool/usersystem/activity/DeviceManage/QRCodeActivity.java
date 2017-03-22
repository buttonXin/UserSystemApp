package com.dopool.usersystem.activity.DeviceManage;

import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.dopool.usersystem.R;

public class QRCodeActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    private QRCodeReaderView mQr_two_xing;
    private Button mBtn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_qrcode);

        initView();
    }

    private void initView() {
        mQr_two_xing = (QRCodeReaderView) findViewById(R.id.qr_two_xing);
        mQr_two_xing.setOnQRCodeReadListener(this);
        mQr_two_xing.setQRDecodingEnabled(true);
        // Use this function to change the autofocus interval (default is 5 secs)
        mQr_two_xing.setAutofocusInterval(2000L);
        // Use this function to enable/disable Torch
        mQr_two_xing.setTorchEnabled(true);
        // Use this function to set front camera preview
        mQr_two_xing.setFrontCamera();
        // Use this function to set back camera preview
        mQr_two_xing.setBackCamera();

        mBtn_back = (Button) findViewById(R.id.btn_back);

        mBtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Intent intent = new Intent();
        intent.putExtra("result", text);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mQr_two_xing.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
