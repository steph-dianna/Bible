package com.example.bible;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Book {

    private String name;
    private String chapitre;
    private String verset;

    public Book(){}
    @ParcelConstructor
    public Book(String name, String chapitre){
            this.name = name;
            this.chapitre = chapitre;
            this.verset = verset;

        }

        public String getName(){
            return name;
        }
        public String getChapter(){
            return chapitre;
        }
        public String getVerset(){
            return verset;
        }

        public void setName(String name){
        this.name = name;
        }

        public void setChapitre(String chapitre){
        this.chapitre = chapitre;
        }

        public void setVerset(String verset){
        this.verset =verset;
        }

}
