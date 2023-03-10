package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = "MainActivity2";
    private BottomNavigationView bottom_navigation;

    RecyclerView rvLivres;
    AdapterBoock adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        rvLivres = findViewById(R.id.rvLivres);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        //Recycler view setup: layout manager and the adapter
//        rvLivres.setLayoutManager(layoutManager);
//        rvLivres.setAdapter(adapter);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment action_home = new PrincipalFragment();
        final Fragment action_book = new BookFragment();
        final Fragment action_more = new MoreFragment();

        bottom_navigation = findViewById(R.id.bottom_navigation);

        // handle navigation selection
        bottom_navigation.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                fragment = action_home;
                                break;
                            case R.id.action_book:
                                fragment = action_book;
                                break;
                            case R.id.action_more:
                            default:
                                fragment = action_more;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.Frame, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottom_navigation.setSelectedItemId(R.id.action_home);
    }
}