package edu.ncsu.calorietracker.db.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Meal {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String mealName;
    private int calorie;
    private Date submitTime;

    public Meal() {
    }

    public Meal(String meal, int calorie) {
        this.mealName = meal;
        this.calorie = calorie;
        this.submitTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getCalorie() {
        return calorie;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
}