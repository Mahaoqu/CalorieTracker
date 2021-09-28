package edu.ncsu.calorietracker.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import edu.ncsu.calorietracker.databinding.RecyclerviewItemBinding;
import edu.ncsu.calorietracker.db.Meal;
import edu.ncsu.calorietracker.R;

public class WordListAdapter extends ListAdapter<Meal, WordListAdapter.WordViewHolder> {

    public static class WordViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewItemBinding binding;

        private WordViewHolder(RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Meal meal) {
            binding.mealCal.setText(Integer.toString(meal.getCalorie()));
            binding.mealName.setText(meal.getMeal());
        }

        static WordViewHolder create(ViewGroup parent) {
            return new WordViewHolder(
                    RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)
            );
        }
    }

    public WordListAdapter(@NonNull DiffUtil.ItemCallback<Meal> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return WordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Meal current = getItem(position);
        holder.bind(current);
    }

    static class WordDiff extends DiffUtil.ItemCallback<Meal> {

        @Override
        public boolean areItemsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal oldItem, @NonNull Meal newItem) {
            return oldItem.getMeal().equals(newItem.getMeal());
        }
    }
}
