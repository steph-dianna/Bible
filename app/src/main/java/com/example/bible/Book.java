package com.example.bible;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Book {

    private String name;
    private int chapitre;
    private String verset;

    public Book(){}
    @ParcelConstructor
    public Book(String name, int chapitre){
            this.name = name;
            this.chapitre = chapitre;
            this.verset = verset;

        }

        public String getName(){
            return name;
        }
        public int getChapter(){
            return chapitre;
        }
        public String getVerset(){
            return verset;
        }

        public void setName(String name){
        this.name = name;
        }

        public void setChapitre(int chapitre){
        this.chapitre = chapitre;
        }

        public void setVerset(String verset){
        this.verset =verset;
        }


}
