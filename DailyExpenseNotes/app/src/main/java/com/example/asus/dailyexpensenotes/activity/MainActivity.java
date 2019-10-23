package com.example.asus.dailyexpensenotes.activity;

import androidx.annotation.NonNull;

import com.example.asus.dailyexpensenotes.fragment.DashBoardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.asus.dailyexpensenotes.R;
import com.example.asus.dailyexpensenotes.fragment.ExpensesFragment;

public class MainActivity extends AppCompatActivity {

    private int mark=0;
    private int mark1=1;

    public BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dash Board");

        init();

        replaceFragment(new DashBoardFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.dashBoardNavItemId:

                        if(mark1==0 && mark==0) {
                            replaceFragment(new DashBoardFragment());
                            mark1++;
                        }
                        setTitle("Dash Board");

                        return true;
                    case R.id.expensesNavItemId:

                        if(mark1==1 && mark==0) {
                            mark1--;
                            replaceFragment(new ExpensesFragment());
                        }
                        setTitle("Expenses");

                        return true;
                }
                return false;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId,fragment);
        fragmentTransaction.commit();
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavigationViewId);
    }
}
