package edu.ncsu.calorietracker.ui.dashboard;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import edu.ncsu.calorietracker.databinding.RecyclerviewItemBinding;
import edu.ncsu.calorietracker.db.entity.Meal;

public class WordListAdapter extends ListAdapter<Meal, WordListAdapter.WordViewHolder> {

    public static class WordViewHolder extends RecyclerView.ViewHolder {

        RecyclerviewItemBinding binding;

        private WordViewHolder(RecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Meal meal) {
            binding.mealCal.setText(Integer.toString(meal.getCalorie()));
            binding.mealName.setText(meal.getMealName());
            binding.mealTime.setText(LocalDateTime.ofInstant(
                    meal.getSubmitTime().toInstant(), ZoneId.systemDefault())
                    .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
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
            return oldItem.getMealName().equals(newItem.getMealName());
        }
    }
}
