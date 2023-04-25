package com.example.bible;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FrBook extends Fragment {

    public static final String TAG = "FrBook";
    RecyclerView recyclerView;
    Context context;
    protected List<Book> Books;
    protected AdapterBook adapter;

    public FrBook() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvLivres);
        Books = new ArrayList<>();

        adapter = new AdapterBook(getContext(), Books);

        adapter.setOnItemClickListener(new AdapterBook.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent intent = new Intent(getContext(),Chapiter.class);
                Book book = Books.get(position);
                intent.putExtra("livre", Parcels.wrap(book));

                startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        try {
            bookItem();
            texte();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    private void bookItem() throws IOException {
        AssetManager manager = getActivity().getAssets();
        InputStream inputStream = manager.open("NameBooks.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null){
            String[] data = line.split(":");
            String nom = data[0].trim();
            String nbrChapitre = data[1].trim();
//            String nbrVerset = data[2].trim();

            Book book = new Book(nom,Integer.parseInt(nbrChapitre));
            Books.add(book);
        }
        reader.close();
//
//        InputStream inputStream = getAssets().open("segond_1910.json");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String ligne;
//        while ((ligne = bufferedReader.readLine()) != null) {
//            stringBuilder.append(ligne);
//        }
//        String contenuFichierJson = stringBuilder.toString();
//
//        try{
//        JSONObject objetJson = new JSONObject(contenuFichierJson);
//
//        JSONArray tableauPersonnes = objetJson.getJSONArray("personnes");
//        for (int i = 0; i < tableauPersonnes.length(); i++) {
//            JSONObject objetPersonne = tableauPersonnes.getJSONObject(i);
//            String nom = objetPersonne.getString("nom");
//            int age = objetPersonne.getInt("age");
//            boolean estMarie = objetPersonne.getBoolean("estMarie");
//            // Faites quelque chose avec les propriétés de l'objet personne
//        }}catch (JSONException e) {
//            e.printStackTrace();
//        }
//
    }

    private void texte() throws IOException {
        try {
        InputStream inputStream = getAssets().open("segond_1910.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();

            JSONObject jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private AssetManager getAssets() {
        AssetManager assets = null;
        if (assets == null) {
            assets=getActivity().getAssets();
        }
        return(assets);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fr_boock, container, false);
    }
}