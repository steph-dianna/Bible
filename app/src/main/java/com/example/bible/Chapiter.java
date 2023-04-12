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
    AdapterChapter chapter;
    protected ArrayList<Book> bookArrayList;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Chapiter.this,DetailBook.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent,0);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapiter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.grid);

        ArrayList<Integer> bookChapter = new ArrayList<Integer>();



            // faire quelque chose avec le nom du livre
        Book livres = Parcels.unwrap(getIntent().getParcelableExtra("livre"));
        TextView textView = findViewById(R.id.textView);
        textView.setText(livres.getName());



//
//        // using toolbar as ActionBar
        //setSupportActionBar(toolbar);

//        // Display icon in the toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);


        for(int i = 1; livres.getChapter() >= i; i++){
            bookChapter.add(i);
        }

        AdapterChapter adapter = new AdapterChapter(this,bookChapter);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Chapiter.this, DetailBook.class);
                intent.putExtra("chapitre", String.valueOf(bookChapter.get(i)));
                intent.putExtra("livre", Parcels.wrap(livres));
                startActivity(intent);
            }
        });
    }
}