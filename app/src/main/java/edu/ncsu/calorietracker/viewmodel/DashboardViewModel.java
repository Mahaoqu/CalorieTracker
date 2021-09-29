package edu.ncsu.calorietracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.ncsu.calorietracker.db.entity.Meal;
import edu.ncsu.calorietracker.repository.MealRepository;
import edu.ncsu.calorietracker.repository.UserRepository;

public class DashboardViewModel extends AndroidViewModel {

    private MutableLiveData<List<Meal>> meals;
    private MealRepository mealRepository;

    public DashboardViewModel(Application application) {
        super(application);
        mealRepository = new MealRepository(application);
    }

    public LiveData<List<Meal>> getMeals() {
        return mealRepository.getAllMeals();
    }

    public void addMeal(int cal) {
        mealRepository.insert(new Meal("a meal", cal));
    }
}