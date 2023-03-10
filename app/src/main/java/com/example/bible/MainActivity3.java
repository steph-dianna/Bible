package com.example.bible;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bible.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMain3Binding binding;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            listView.findViewById(R.id.listview);
            String values []= new String[]{
                    "Genèse", "Exode"
                    ,"Lévitique","Nombres", "Deutéronome","Josué", "Juges", "Ruth", "1 Samuel",
                    "2 Samuel", "1 Rois", "2 Rois", "1 Chroniques", "2 Chroniques", "Esdras", "Néhémie", "Esther",
                    "Job", "Psaumes", "Proverbes", "Ecclésiaste", "Cantique des cantiques",
                    "Ésaïe", "Jérémie", "Lamentations", "Ézéchiel", "Daniel", "Osée",
                    "Joël","Amos", "Abdias", "Jonas", "Michée", "Nahum", "Habacuc",
                    "Sophonie", "Aggée", "Zacharie", "Malachie", "Matthieu", "Marc",
                    "Luc", "Jean","Actes des Apôtres", "Romains", "1 Corinthiens", "2 Corinthiens",
                    "Galates", "Éphésiens", "Philippiens", "Colossiens", "1 Thessaloniciens",
                    "2 Thessaloniciens", "1 Timothée", "2 Timothée", "Tite", "Philémon",
                    "Hébreux", "Jacques", "1 Pierre", "2 Pierre", "1 Jean", "2 Jean",
                    "3 Jean", "Jude", "Apocalypse" };

            ArrayAdapter adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    android.R.id.text2,values);
            listView.setAdapter(adapter);

    }
}