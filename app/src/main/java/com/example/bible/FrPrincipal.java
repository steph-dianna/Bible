package com.example.bible;

import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FrPrincipal extends Fragment {

    public static final String TAG = "FrPrincipal";

    public FrPrincipal() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> fileNames  = new ArrayList<>();

//        try {
//            // Open the asset manager
//            AssetManager assetManager = getAssets();
//
//            // Get a list of all files in the "texteBiblique" folder
//            String[] files = assetManager.list("texteBiblique");
//
//            // Add the file names to the list
//            for (String fileName : files) {
//                fileNames .add(fileName);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

// Now fileNames list contains the names of all files in the "texteBiblique" folder
//        if (!fileNames.isEmpty()) {
//            Random random = new Random();
//            String randomFileName = fileNames.get(random.nextInt(fileNames.size()));
//            // Now randomFileName contains the name of a randomly selected file
//            String json = null;
//            String livre =randomFileName.toLowerCase().replace("é","e").replace("ë","e").replace("è","e").replace("ï","i").replace(" ","");
//
//            try {
//                InputStream is = getAssets().open(String.format("texteBiblique/%s.json",livre));
//                int size = is.available();
//                byte[] buffer = new byte[size];
//                is.read(buffer);
//                is.close();
//                json = new String(buffer, "UTF-8");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            List<Verse> verses = new ArrayList<>();
//            Log.i("verset",livre);
//
//            JSONObject jsonObject = null;
//            try {
//                jsonObject = new JSONObject(json);
//                JSONArray jsonArray = jsonObject.getJSONArray("verses");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject verseObject = jsonArray.getJSONObject(i);
//
//                        Verse verse = new Verse();
//                        verse.setText(verseObject.getString("text"));
//                        verse.setVerse(verseObject.getInt("verse"));
//                        verses.add(verse);}
//                Verse verset = verses.get(random.nextInt(verses.size()));
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            } else {
//            // The list of file names is empty
//        }
//
//    }

//    private AssetManager getAssets() {
//        AssetManager assets = null;
//        if (assets == null) {
//            assets=getActivity().getAssets();
//        }
//        return(assets);
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_fr_principal, container, false);
//    }
}}