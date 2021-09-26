package edu.ncsu.calorietracker.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Meal {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private int id;



    public Meal() {

    }
}
