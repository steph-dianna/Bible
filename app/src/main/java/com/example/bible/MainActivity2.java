package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    public static final String TAG = "MainActivity2";
    private BottomNavigationView bottom_navigation;

    RecyclerView rvLivres;
    AdapterBook adapter;
    Button bouton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        rvLivres = findViewById(R.id.rvLivres);

//        bouton = findViewById(R.id.button);
//        bouton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity2.this,Essai.class);
//                startActivity(i);
//            }
//        });

      final FragmentManager fragmentManager = getSupportFragmentManager();
////
        // define your fragments here
        final Fragment action_home = new FrPrincipal();
        final Fragment action_book = new FrBook();
        final Fragment action_more = new FrMore();

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