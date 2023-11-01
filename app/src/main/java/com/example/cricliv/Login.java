package com.example.cricliv;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;

import java.text.BreakIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView s_up=findViewById(R.id.create);
        Button lbtn=findViewById(R.id.loginbutton);


        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              doLogin();
            }
        });

        s_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAcc();
            }
        });
    }
    public void doLogin()
    {
        ApiInterface api= RetrofitClient.getretrofit().create(ApiInterface.class);
        EditText usn=findViewById(R.id.username);
        EditText pass=findViewById(R.id.password);

    }
    public void createAcc()
    {
        finish();
        Intent intent = new Intent(Login.this,SignUp.class);
        startActivity(intent);
    }
    public void checklog()
    {
        EditText usn=findViewById(R.id.username);
        EditText pass=findViewById(R.id.password);

        String st=usn.getText().toString();

        String st2=pass.getText().toString();

        TextView tx1=findViewById(R.id.forgetpass);
        TextView tx2=findViewById(R.id.create);

        tx1.setText(st);
        tx2.setText(st2);

    }
}