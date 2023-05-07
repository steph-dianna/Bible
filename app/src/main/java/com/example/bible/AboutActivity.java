package com.example.bible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AboutActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        mTextView = findViewById(R.id.text_view_id);
        try {
            lireFichier();
        }catch (IOException e){
            e.printStackTrace();
        }

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