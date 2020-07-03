package com.example.firebasenna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnDangKy;
    EditText edtEmail, edtPassword;
    FirebaseAuth mAuthencation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthencation = FirebaseAuth.getInstance();
        Fire();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangKy();
            }
        });
    }
    private  void DangKy(){
        String email= edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
       mAuthencation.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   Toast.makeText(MainActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(MainActivity.this,"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
               }
           }
       });


    }
    private void Fire(){
        btnDangKy   = (Button) findViewById(R.id.btn_dangky);
        edtEmail    = (EditText) findViewById(R.id.et_name);
        edtPassword = (EditText) findViewById(R.id.et_pass);
    }
}