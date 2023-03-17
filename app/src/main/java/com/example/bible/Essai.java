package com.example.bible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Essai extends AppCompatActivity {


    public static final String TAG = "FrBook";
    RecyclerView recyclerView;
    Context context;
    protected List<Book> Books;
    protected AdapterBook adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essai);


        recyclerView = findViewById(R.id.end);
        Books = new ArrayList<>();

        adapter = new AdapterBook(Essai.this, Books);

//        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AdapterBook.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(Essai.this,Chapiter.class);
                Book book = Books.get(position);
                intent.putExtra("NameBooks.txt", Parcels.wrap(book));

                Essai.this.startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(Essai.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        try {
            bookItem();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void bookItem() throws IOException {
        AssetManager manager = getAssets();
        InputStream inputStream = manager.open("NameBooks.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null){
            String[] data = line.split(":");
            String nom = data[0].trim();
            String nbrChapitre = data[1].trim();

            Book book = new Book(nom,nbrChapitre);
            Books.add(book);
        }
        reader.close();
    }

}