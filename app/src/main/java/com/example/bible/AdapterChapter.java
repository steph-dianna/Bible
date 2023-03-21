package com.example.bible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterChapter extends ArrayAdapter<Integer> {

    public AdapterChapter(Context context, ArrayList<Integer> nbrInteger){
        super(context,0,nbrInteger);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.entrychapter, parent, false);
        }

        Integer interger = getItem(position);
        TextView tvItemChapitre = listitemView.findViewById(R.id.button);


        tvItemChapitre.setText(interger.toString());

        return listitemView;
}}

