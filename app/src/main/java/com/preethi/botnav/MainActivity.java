package com.preethi.botnav;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.Normalizer;

import javax.crypto.NullCipher;
import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_tags);
    }
    Tags tagsFragment=new Tags();
    Trending trendingFragment=new Trending();
    Explore exploreFragment=new Explore();
    Saved savedFragment=new Saved();

    public boolean onNavigationItemSelected(@NonNull MenuItem Item){
            switch (Item.getItemId()){
                case R.id.navigation_tags:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,tagsFragment).commit();
                    return true;
                case R.id.navigation_trending:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,trendingFragment).commit();
                    return true;
                case R.id.navigation_explore:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,exploreFragment).commit();
                    return true;
                case R.id.navigation_saved:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,savedFragment).commit();
                    return true;
            }
        
        return false;
    }
}