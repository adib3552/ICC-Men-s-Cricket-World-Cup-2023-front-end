package com.example.cricliv;

import androidx.annotation.NonNull;
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

    private ApiInterface apiInterface;//eigula global e declare korar try korbi ar instantiate constructor er bhitore korle bhalo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        System.out.println("hello mf");
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
        apiInterface= RetrofitClient.getretrofit().create(ApiInterface.class);
        EditText fi_name=findViewById(R.id.f_name);
        EditText se_name=findViewById(R.id.s_name);
        EditText mail=findViewById(R.id.email);
        EditText pas=findViewById(R.id.password);
        EditText mb=findViewById(R.id.mobile_num);
        long number=0;

      User us= new User(fi_name.getText().toString(),
              se_name.getText().toString(),
              mail.getText().toString(),
              pas.getText().toString(), 1);

        System.out.println(us);

        /**
         * res folder a ekta file add korsi network_security_config.xml eita
         * eita mainly tor form login er por url a information encrypted hoya jay eita prevent kore
         * eita na korle backend hoilo permit dey na. Eitar jonno abr backend a change kora lagto eijonno
         * eita halka insecure banailam apatoto pera nai
         */

        apiInterface.saveuser(us).enqueue(
                new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        Toast.makeText(SignUp.this, "successful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Toast.makeText(SignUp.this, t.toString(), Toast.LENGTH_LONG).show();
                        System.out.println(t);
                    }
                }
        );


        Intent intent = new Intent(SignUp.this,Login.class);
        startActivity(intent);

    }
}