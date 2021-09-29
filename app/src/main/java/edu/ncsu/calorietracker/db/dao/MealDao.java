package edu.ncsu.calorietracker.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.ncsu.calorietracker.db.entity.Meal;

// Primary Key of meals are their name
// They also contain an int called calorie that tracks the calorie of the meal
@Dao
public interface MealDao {
    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * FROM meal ORDER BY mealName ASC")
    LiveData<List<Meal>> getMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    @Query("SELECT calorie FROM meal WHERE mealName = :mealName")
    int getCalorie(String mealName);

    @Query("DELETE FROM meal")
    void deleteAll();

    @Update
    void updateMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);
}
