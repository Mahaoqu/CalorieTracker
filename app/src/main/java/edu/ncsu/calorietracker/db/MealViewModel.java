package edu.ncsu.calorietracker.db;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * View Model to keep a reference to the Meal repository and
 * an up-to-date list of all Meals.
 */

public class MealViewModel extends AndroidViewModel {

    private MealRepository mRepository;
    // Using LiveData and caching what getAlphabetizedMeals returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private final LiveData<List<Meal>> mAllMeals;

    public MealViewModel(Application application) {
        super(application);
        mRepository = new MealRepository(application);
        mAllMeals = mRepository.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals() {
        return mAllMeals;
    }

    void insert(Meal Meal) {
        mRepository.insert(Meal);
    }
}