package com.example.bible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.ViewHolder> {

    public static final String TAG = "AdapterBook";
    public static Context context;
    public  List<Book> Books;

    public AdapterBook(Context context, List<Book> Books){
        this.context = context;
        this.Books = Books;
    }

    public interface OnItemClickListener{
        void onItemClick(View itemView, int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public AdapterBook.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.entry,parent,false);
        AdapterBook.ViewHolder viewHolder = new ViewHolder(view,listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBook.ViewHolder holder, int position) {
    Book book = Books.get(position);
    holder.bind(book,holder);
    }

    @Override
    public int getItemCount() {

        return Books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            textView = itemView.findViewById(R.id.modele);
            // initialiser vos vues ici
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // appeler la méthode onItemClick ici
                    if (listener != null) {
                        listener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }

        public void bind(Book book, ViewHolder holder) {
            textView.setText(book.getName());
        }
    }
}
