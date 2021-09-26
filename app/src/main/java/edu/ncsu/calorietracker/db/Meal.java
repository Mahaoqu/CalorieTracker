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

    @ColumnInfo(name = "calorie")
    private int mCalorie;

    public Meal(@NonNull String meal, int calorie) {
        this.mMeal = meal;
        this.mCalorie = calorie;
    }

    @NonNull
    public String getMeal() { return this.mMeal; }

    public void setCalorie(int calorie) {
        mCalorie = calorie;
    }

    public int getCalorie() {
        return mCalorie;
    }

    public void setMeal(String meal) {
        mMeal = meal;
    }
}