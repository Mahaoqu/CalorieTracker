package edu.ncsu.calorietracker.ui.caldemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import edu.ncsu.calorietracker.databinding.FragmentCheckHealthBinding;


public class CheckHealthFragment extends Fragment {
    FragmentCheckHealthBinding binding;

    int user_weight;
    int user_calories;
    String user_gender;
    int user_age;
    int user_height;
    double standardCalories;

    public CheckHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCheckHealthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.submitButton.setOnClickListener(
                view -> {
                    try {
                        user_calories = Integer.valueOf(binding.caloriesInput.getText().toString());
                        user_weight = Integer.valueOf(binding.weightInput.getText().toString());
                        user_gender = binding.genderInput.getText().toString();
                        user_height = Integer.valueOf(binding.heightInput.getText().toString());
                        user_age = Integer.valueOf(binding.ageInput.getText().toString());
                        standardCalories = getStandardCalories(user_weight, user_gender, user_height, user_age);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Null Input");
                        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getContext());
                        dialog.setMessage("Invalid Input");
                    }

                    //TODO
                    /**
                     * to calculate if the user is healthy
                     * The formula is:
                     * Adult male: 66 + (6.3 x body weight in lbs.) + (12.9 x height in inches) - (6.8 x age in years) = BMR
                     * Adult female: 655 + (4.3 x weight in lbs.) + (4.7 x height in inches) - (4.7 x age in years) = BMR
                     */
                    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getContext());
                    if (standardCalories <= 0 || user_calories == standardCalories) {
                        dialog.setMessage("Invalid Input");
                    } else if (user_calories < standardCalories) {
                        dialog.setMessage("Congratulations! You are very healthy!");
                    } else if (user_calories > standardCalories) {
                        dialog.setMessage("Unfortunately, It seems like you've had too many calories today!");
                    } else {
                        dialog.setMessage("Error");
                    }
                    dialog.show();
                });

        return root;
    }

    private double getStandardCalories(int weight, String gender, int height, int age) {

        if (gender.equals("male") || gender.equals("Male") || gender.equals("MALE")) {
            return 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
        } else if (gender.equals("female") || gender.equals("Female") || gender.equals("FEMALE")) {
            return 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
        } else {
            return -1;
        }
    }

}