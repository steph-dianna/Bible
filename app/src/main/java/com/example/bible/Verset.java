package com.example.bible;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;

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

        Book livres = Parcels.unwrap(getIntent().getParcelableExtra("livre"));
        int chapitre = getIntent().getExtras().getInt("chapitre");



        // Read JSON file from assets folder
        String json = null;
        String livre =livres.getName().toLowerCase().replace("-","").replace("é","e")
                .replace("ë","e").replace(" ","").replace("è","e")
                .replace("ï","i").replace("ô","o");

        Log.i("verset",livre);

        try {
            InputStream is = getAssets().open(String.format("texteBiblique/%s.json",livre));
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
                if (verseObject.getInt("chapter")== chapitre){
                Verse verse = new Verse();
                verse.setText(verseObject.getString("text"));
                verse.setVerse(verseObject.getInt("verse"));
                verses.add(verse);}

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Bind VerseAdapter to RecyclerView
        verseAdapter = new VerseAdapter(this,verses);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(verseAdapter);
    }
}

