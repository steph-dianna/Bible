package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

public class Chapiter extends AppCompatActivity {

    GridView gridView;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Chapiter.this,MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent,0);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        gridView = findViewById(R.id.grid);
        ArrayList<Integer> nbreChapitreArrayList = new ArrayList<Integer>();
        Book livres = (Book) Parcels.unwrap(getIntent().getParcelableExtra("livre"));


        TextView textView = findViewById(R.id.textView);
        textView.setText(livres.getName());

        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        // Display icon in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdapterChapter adapter = new AdapterChapter(this, nbreChapitreArrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Chapiter.this, DetailBook.class);
                intent.putExtra("chapitre", nbreChapitreArrayList.get(i));
                intent.putExtra("livre", Parcels.wrap(livres));
                startActivity(intent);
            }
        });
    }


}