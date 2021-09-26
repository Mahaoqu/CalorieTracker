package edu.ncsu.calorietracker.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal_table")
public class Meal {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "meal")
    private String mMeal;

    public Meal(@NonNull String meal) {
        this.mMeal = meal;
    }

    @NonNull
    public String getMeal() {
        return this.mMeal;
    }
}
