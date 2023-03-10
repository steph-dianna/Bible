package com.example.bible;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MathieuChapter extends AppCompatActivity {
    private ListView listView;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_layout);
        Log.i("Mathieu", "onCreate: EXECUTE");

        listView = findViewById(R.id.listview);
        textView = findViewById(R.id.textView);

        final String[] chapter = getResources().getStringArray(R.array.mathieu_chapters);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.entry,R.id.textView,chapter);
        listView.setAdapter(adapter);
        }
    }
