package edu.ncsu.calorietracker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> bmi;
    private MutableLiveData<String> health;
    private MutableLiveData<String> average;


    public HomeViewModel() {
        bmi = new MutableLiveData<>();
        health = new MutableLiveData<>();
        average = new MutableLiveData<>();
    }

    public LiveData<String> getBMI() {
        return bmi;
    }

    public void setBMI(String text) {
        bmi.setValue("BMI: " + text);
    }

    public LiveData<String> getHealth() {
        return health;
    }

    public void setHealth(String text) {
        health.setValue("Your BMI Weight Status is " + text);
    }

    public LiveData<String> getAverageText() {return average;}

    public void setAverageText(String lowerAverage, String highAverage) {
        average.setValue("Your healthy weight should be between " + lowerAverage  + " and " + highAverage);
    }
}