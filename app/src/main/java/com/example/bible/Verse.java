package com.example.bible;

public class Verse {
    private String text;
   // private int chapter;
    private int verse;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public int getChapter() {
//        return chapter;
//    }
//
//    public void setChapter(int chapter) {
//        this.chapter = chapter;
//    }

    public int getVerse() {
        return verse;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }
}
