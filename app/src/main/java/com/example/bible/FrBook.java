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
                Intent intent = new Intent(getActivity(),Chapiter.class);
                Book book = Books.get(position);
                intent.putExtra("NameBooks.txt", Parcels.wrap(book));

                FrBook.this.startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        try {
            bookItem();
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

            Book book = new Book(nom,Integer.parseInt(nbrChapitre));
            Books.add(book);
        }
        reader.close();
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