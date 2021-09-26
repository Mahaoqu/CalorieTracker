package edu.ncsu.calorietracker.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MealRepository {

    private MealDao mMealDao;
    private LiveData<List<Meal>> mAllMeals;

    MealRepository(Application application) {
        MealRoomDatabase db = MealRoomDatabase.getDatabase(application);
        mMealDao = db.MealDao();
        //mAllMeals = mMealDao.getAlphabetizedMeals();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Meal Meal) {
        MealRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMealDao.insert(Meal);
        });
    }
}
