package com.example.cricliv;

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


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button sbtn= findViewById(R.id.S_up);

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSave();
            }
        });

    }
    public void doSave()
    {
        ApiInterface api= RetrofitClient.getretrofit().create(ApiInterface.class);
        EditText fi_name=findViewById(R.id.f_name);
        EditText se_name=findViewById(R.id.s_name);
        EditText mail=findViewById(R.id.email);
        EditText pas=findViewById(R.id.password);
        EditText mb=findViewById(R.id.mobile_num);
        long number=0;

      User us= new User(fi_name.getText().toString(),
              se_name.getText().toString(),
              mail.getText().toString(),
              pas.getText().toString(), 0);

        Call<String> call= api.saveuser(fi_name.getText().toString(),
                se_name.getText().toString(),
                mail.getText().toString(),
                pas.getText().toString(), 0);

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String re=response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(SignUp.this, "hoise", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUp.this, "hote niye hoy nai", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(SignUp.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        finish();
        Intent intent = new Intent(SignUp.this,Login.class);
        startActivity(intent);

    }
}