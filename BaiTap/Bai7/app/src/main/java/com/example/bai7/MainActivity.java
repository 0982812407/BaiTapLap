package com.example.bai7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtSo;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSo = (TextView) findViewById(R.id.txtNumber);
        btnStart = (Button) findViewById(R.id.btnstart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Đếm ngược 20 giây, mỗi giây thực hiện một Tick
                new CountDownTimer(20000, 1000) {


                    @Override
                    public void onTick(long timelengt) {
                        txtSo.setText("" + timelengt / 1000);
                    }

                    public void onFinish() {
                        //Khi kết thúc xuất thông báo ra màn hình
                        Toast.makeText(MainActivity.this, "Kết thúc", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}