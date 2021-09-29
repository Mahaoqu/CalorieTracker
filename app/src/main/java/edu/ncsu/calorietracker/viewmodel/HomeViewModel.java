package edu.ncsu.calorietracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import edu.ncsu.calorietracker.repository.UserRepository;

public class HomeViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    private MutableLiveData<Integer> bmi;
    double weight;
    double height;
//    double bmi;

    final double lowerHealthyBMI = 18.5;
    final double higherHealthyBMI = 24.9;

    public HomeViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<BMIResult> getBMI() {
        return Transformations.map(
                userRepository.getUserById(1), user -> {
                    if (user == null) return null;
                    else
                        return calculateBMI(Integer.parseInt(user.getHeight()), Integer.parseInt(user.getWeight()));
                });
    }

    public BMIResult calculateBMI(double height, double weight) {
        double bmi = (weight / (height * height)) * 10000;
        double lowHealthyBMIWeight = (height * height) / (lowerHealthyBMI / 10000);
        double highHealthyBMIWeight = (height * height) / (higherHealthyBMI / 10000);
        return new BMIResult((int) bmi, (int) lowHealthyBMIWeight, (int) highHealthyBMIWeight);
    }

    public static class BMIResult {
        public int bmi;
        public int lowerHealthBMI;
        public int higherHealthBMI;

        public BMIResult(int bmi, int lowerHealthBMI, int higherHealthBMI) {
            this.bmi = bmi;
            this.lowerHealthBMI = lowerHealthBMI;
            this.higherHealthBMI = higherHealthBMI;
        }
    }
}