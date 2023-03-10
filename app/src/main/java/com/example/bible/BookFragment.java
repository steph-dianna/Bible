package com.example.bible;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


public class BookFragment extends Fragment implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10,
            bnt11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, bnt28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45,
            btn46, btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60, btn61, btn62, btn63, btn64, btn65,
            btn66;

    ListView listView;



    public BookFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_book, container, false);
    }


 //        for (int i = 1; i <= 50; i++) {
//            Button button = btn1.findViewById(R.id.Genese);
//            button.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    switch (v.getId()) {
//                        case R.id.Exode:
//
//                            Intent i = new Intent(view.getContext(),Exode.class);
//                            startActivity(i);
//// Ajoutez ici le code à exécuter Torque le bouton 1 est cliqué
//                            break;
//                            case R.id.Lévitique:
//// Ajoutez ici le code à exécuter lorsque le bouton 2 est cliqué
//                                              }
//                                          }
//                                      });}
//                    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



         btn1 = btn1.findViewById(R.id.Genese);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this,Genese.class);
                startActivity(intent);
            }
        });

        Button button2 = btn2.findViewById(R.id.Exode);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, Exode.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}