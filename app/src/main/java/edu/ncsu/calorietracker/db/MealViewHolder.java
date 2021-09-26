package edu.ncsu.calorietracker.db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.ncsu.calorietracker.R;
import androidx.recyclerview.widget.RecyclerView;

class MealViewHolder extends RecyclerView.ViewHolder {
    private final TextView MealItemView;

    private MealViewHolder(View itemView) {
        super(itemView);
        MealItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        MealItemView.setText(text);
    }

    static MealViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new MealViewHolder(view);
    }
}

