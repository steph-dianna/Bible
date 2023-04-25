package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Verset extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VerseAdapter verseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verset);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Read JSON file from assets folder
        String json = null;
        try {
            InputStream is = getAssets().open("texteBiblique/genesis.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Parse JSON data into Verse objects
        List<Verse> verses = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("verses");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject verseObject = jsonArray.getJSONObject(i);
                Verse verse = new Verse();
                verse.setText(verseObject.getString("text"));
                verse.setVerse(verseObject.getInt("verse"));
                verses.add(verse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Bind VerseAdapter to RecyclerView
        verseAdapter = new VerseAdapter(verses);
        recyclerView.setAdapter(verseAdapter);
    }
}

