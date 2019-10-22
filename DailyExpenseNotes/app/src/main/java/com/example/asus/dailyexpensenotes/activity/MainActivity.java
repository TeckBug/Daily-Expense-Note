package com.example.asus.dailyexpensenotes.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.asus.dailyexpensenotes.R;
import com.example.asus.dailyexpensenotes.fragment.ExpensesFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dash Board");

        init();

        //navigation item selected action
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.dashBoardNavItemId:
                        return true;
                    case R.id.expensesNavItemId:
                        replaceFragment(new ExpensesFragment());
                        setTitle("Expenses");
                        return true;
                }
                return false;
            }
        });

    }

    //change fragment when nav item selected
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId,fragment);
        fragmentTransaction.commit();
    }

    //initialize all component
    private void init() {
        bottomNavigationView = findViewById(R.id.bottomNavigationViewId);
    }
}
