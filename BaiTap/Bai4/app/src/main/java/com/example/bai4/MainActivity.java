package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView year;
    TextView notice;
    Button btnCal;
    int age;
    Activity age_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCal = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.editText);
        year = (TextView) findViewById(R.id.editText2);
        notice = (TextView) findViewById(R.id.textView2);
        notice.setTextColor(Color.BLUE);
        notice.setTextSize(24);
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(year.getText().toString());
                notice.setText("Bạn:" + name.getText() + ' ' + age + "Tuổi:");
            }
        });
    }
}
