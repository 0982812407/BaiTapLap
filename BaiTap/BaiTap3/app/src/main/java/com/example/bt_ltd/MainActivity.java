package com.example.bt_ltd;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;


import com.example.bt_ltd.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        final View view = mainBinding.getRoot();
        setContentView(view);
        //su kien togglebutton
        mainBinding.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean check =  mainBinding.toggleButton.isChecked();
                if(check){
                    mainBinding.toggleButton.setChecked(true);
                    Toast.makeText(MainActivity.this, "Đã có gia đình!",Toast.LENGTH_SHORT).show();
                }else{
                    mainBinding.toggleButton.setChecked(false);
                    Toast.makeText(MainActivity.this, "Chưa có gia đình!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // su kien checkbox
        mainBinding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean check = mainBinding.checkBox.isChecked();
                if(check){
                    mainBinding.checkBox.setChecked(true);
                    Toast.makeText(MainActivity.this, "Nam",Toast.LENGTH_SHORT).show();
                }else{
                    mainBinding.checkBox.setChecked(false);
                    Toast.makeText(MainActivity.this,"Nữ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //su kien dang ky
        mainBinding.btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cb;
                if(mainBinding.checkBox.isChecked()){
                    cb = "Nam";
                }else {
                    cb = "Nữ";
                }
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Nội dung đã nhập!");
                ab.setMessage("Tên người dùng: " + mainBinding.editText.getText() + "\r\n"
                        + "Giới tính: " + cb + "\r\n"
                        + "Single: " + mainBinding.toggleButton.getText() + "\r\n"
                        + "Ngày sinh: " + mainBinding.editText2.getText()+ "\r\n"
                        + "Email: " + mainBinding.editText3.getText() + "\r\n"
                        + "Mật khẩu: " + mainBinding.editText4.getText() + "\r\n") ;
                ab.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
                ab.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Đăng ký thất bại!",Toast.LENGTH_SHORT).show();
                    }
                });
                ab.show();
            }
        });


    }



}
