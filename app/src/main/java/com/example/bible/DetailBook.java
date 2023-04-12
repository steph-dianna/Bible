package com.example.bible;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

import org.parceler.Parcels;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DetailBook extends AppCompatActivity {
    PDFView pdfView;
    ProgressBar progressBar;
    String API_KEy="https://laparolequichange.org/messages/";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(DetailBook.this,Chapiter.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent,0);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

//        Toolbar toolbar = findViewById(R.id.toolbar);

        progressBar =findViewById(R.id.pb);

        Book book = Parcels.unwrap(getIntent().getParcelableExtra("livre"));

        int chapterNber = getIntent().getExtras().getInt("chapitre");

        String nameBook = book.getName().replaceAll("\\s","").replaceAll("è","e").replaceAll("é","e")
                .replaceAll("ï","i").replaceAll("ë","e");


        API_KEy = API_KEy + nameBook.toLowerCase() + String.valueOf(chapterNber) + ".pdf";


        // initializing our pdf view.
        pdfView = findViewById(R.id.pdfView);
        new RetrievePDFfromUrl().execute(API_KEy);

        // set a text in the toolbar
        TextView textView = findViewById(R.id.textView);
        textView.setText(book.getName() + " " + String.valueOf(chapterNber)  );

        // using toolbar as ActionBar
        //setSupportActionBar(toolbar);

        // Display icon in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    class RetrievePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            progressBar.setVisibility(ProgressBar.VISIBLE);
            progressBar.bringToFront();

            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are
                // creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            pdfView.fromStream(inputStream).load();
            progressBar.setVisibility(ProgressBar.INVISIBLE);

        }

    }
}