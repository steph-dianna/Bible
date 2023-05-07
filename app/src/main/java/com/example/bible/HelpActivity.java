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

    TextView mTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



        mTextView1 = findViewById(R.id.id_text_view);
        try {
            lireFichier();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void lireFichier() throws IOException {
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open("help.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Traiter chaque ligne ici
            stringBuilder.append(line);
            stringBuilder.append("\n");

            mTextView1.setText(stringBuilder);
        }


        reader.close();
    }
}


