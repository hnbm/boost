package com.example.boost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentArticle fragmentArticle = new FragmentArticle();
    private FragmentEconomy fragmentEconomy = new FragmentEconomy();
    private FragmentSimulation fragmentSimulation = new FragmentSimulation();
    OnBackPressedListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentArticle).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());
    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch(menuItem.getItemId()) {
                case R.id.articleItem:
                    transaction.replace(R.id.frameLayout, fragmentArticle).commitAllowingStateLoss();
                    return true;
                //break;
                case R.id.economyItem:
                    transaction.replace(R.id.frameLayout, fragmentEconomy).commitAllowingStateLoss();
                    return true;
                //break;
                case R.id.simulationItem:
                    transaction.replace(R.id.frameLayout, fragmentSimulation).commitAllowingStateLoss();
                    return true;
                //break;
                default:
                    return false;
            }
        }
    }

    public void setOnBackPressedListener(OnBackPressedListener listener){
        this.listener = listener;
    }

    @Override
    public void onBackPressed() {
        if(listener != null){
            listener.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }
}
