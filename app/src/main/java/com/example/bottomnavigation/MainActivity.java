package com.example.bottomnavigation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    String string = "Hey! This is Monim";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomBarId);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.FrameViewId, new HomeSubActivity()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId()==R.id.HomeId){
                    fragment = new HomeSubActivity();
                }
                if(item.getItemId()==R.id.SettingId){
                    fragment = new SettingSubActivity();
                }
                if(item.getItemId()==R.id.ProfileId){
                    fragment = new ProfileSubActivity();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.FrameViewId, fragment).commit();

                return false;
            }
        });
    }
}