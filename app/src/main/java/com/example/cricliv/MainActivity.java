package com.example.cricliv;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView= findViewById(R.id.navi_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                    {
                       news();
                        break;
                    }
                    case R.id.matches:
                    {
                        Intent intent= new Intent(MainActivity.this,Matches.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.fantasy:
                    {
                        Intent intent= new Intent(MainActivity.this,Fantasy.class);
                        startActivity(intent);
                        break;

                    }
                    case R.id.login:
                    {

                        Toast.makeText(MainActivity.this,"In Login",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    public void news()
    {
//        ApiInterface api= RetrofitClient.getretrofit().create(ApiInterface.class);
//        Call<List<Story>> call = api.getStories();
//        call.enqueue(new Callback<List<Story>>() {
//            @Override
//            public void onResponse(Call<List<Story>> call, Response<List<Story>> response) {
//                if (response.isSuccessful()) {
//                    List<Story> stories = response.body();
//                    // Handle the list of stories
//                    for (Story story : stories) {
//                        Toast.makeText(MainActivity.this, "okk", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(MainActivity.this, "not okay", Toast.LENGTH_SHORT).show();
//                    // Handle unsuccessful response
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Story>> call, Throwable t) {
//                Log.d(TAG, "Error: " + t.getMessage());
//                // Handle failure
//            }
//        });
    }
}