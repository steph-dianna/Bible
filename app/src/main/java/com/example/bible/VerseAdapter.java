package com.example.bible;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class VerseAdapter extends RecyclerView.Adapter<VerseAdapter.ViewHolder> {
    private List<Verse> verses;

    public VerseAdapter(List<Verse> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.entry_verse, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Verse verse = verses.get(position);
        holder.textTextView.setText(verse.getText());
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Verse textTextView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.item_verse);

        }
    }
}
