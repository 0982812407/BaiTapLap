package com.example.bt2ltdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnChangeImg;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeImg = (Button) findViewById(R.id.btnchangeimg);
        imgview = (ImageView) findViewById(R.id.imgView);

        imgview.setBackgroundResource(R.mipmap.r);
        btnChangeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview.setBackgroundResource(R.mipmap.maxresdefault);
            }
        });
    }
}
