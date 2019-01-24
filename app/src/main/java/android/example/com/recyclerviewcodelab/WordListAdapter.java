package android.example.com.recyclerviewcodelab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{
    private LinkedList<String> wordList = new LinkedList<>();

    public WordListAdapter(Context context, LinkedList<String> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.wordlist_views, viewGroup, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {
        String current = wordList.get(i);
        wordViewHolder.wordItemView.setText(current);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView wordItemView;
        private WordListAdapter wordAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.wordAdapter = adapter;
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = wordList.get(mPosition);
            wordList.set(mPosition, "Clicked! " + element);
            wordAdapter.notifyDataSetChanged();
        }
    }
}
