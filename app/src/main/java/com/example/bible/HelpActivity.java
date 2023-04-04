package com.example.bible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HelpActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


//        // assigning ID of the toolbar to a variable
        Toolbar toolbar = findViewById(R.id.toolbar);

        // using toolbar as ActionBar
       //setSupportActionBar(toolbar);
//
//
//        // Display icon in the toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);



        mTextView = findViewById(R.id.text_view_id);
        try {
            lireFichier();
        }catch (IOException e){
            e.printStackTrace();
        }


//        mTextView.setText("Nouveau texte à afficher");
//
//        mTextView.setTextColor(Color.RED);
//        mTextView.setTextSize(20);





    }

    private void lireFichier() throws IOException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open("About.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Traiter chaque ligne ici
            stringBuilder.append(line);
            stringBuilder.append("\n");

            mTextView.setText(stringBuilder);
        }


        reader.close();
    }
}


