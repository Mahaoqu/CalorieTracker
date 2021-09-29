package edu.ncsu.calorietracker.ui.caldemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import edu.ncsu.calorietracker.databinding.FragmentCheckHealthBinding;
import edu.ncsu.calorietracker.ui.notifications.User;
import edu.ncsu.calorietracker.ui.notifications.UserDatabase;
import edu.ncsu.calorietracker.viewmodel.HomeViewModel;
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;


public class CheckHealthFragment extends Fragment {
    private HomeViewModel homeViewModel;
    FragmentCheckHealthBinding binding;

    double weight;
    double height;
    double bmi;
    double lowerHealthyBMI = 18.5;
    double higherHealthyBMI = 24.9;
    double lowHealthyBMIWeight;
    double highHealthyBMIWeight;
    String weightStatus;

    private UserDatabase mUserDb;

    public CheckHealthFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserDb = UserDatabase.getInstance(this.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentCheckHealthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        User user = mUserDb.userDao().getUser(1);
        weight = Integer.valueOf(user.getWeight());
        height = Integer.valueOf(user.getHeight());
        bmi = (weight/(height*height)) * 10000;

        if(bmi >= 30.0) weightStatus = "obese";
        else if(bmi >= 25.5 && bmi <= 29.9) weightStatus = "overweight";
        else if (bmi >= 18.5 && bmi <= 24.9) weightStatus = "healthy";
        else weightStatus = "underweight";

        lowHealthyBMIWeight = (height*height)/(lowerHealthyBMI/10000);
        highHealthyBMIWeight = (height*height)/(higherHealthyBMI/10000);

        final TextView bmiView = binding.userBMI;
        final TextView healthView = binding.health;
        final TextView averageView = binding.averageWeight;


        homeViewModel.setBMI(String.valueOf(bmi));
        homeViewModel.setHealth(weightStatus);

        homeViewModel.getBMI().observe(getViewLifecycleOwner(), bmiView::setText);
        homeViewModel.getHealth().observe(getViewLifecycleOwner(), healthView::setText);

        // Must send lower-bound first and higher-bound second
        homeViewModel.setAverageText(String.valueOf(lowerHealthyBMI), String.valueOf(higherHealthyBMI));
        homeViewModel.getAverageText().observe(getViewLifecycleOwner(), averageView::setText);

        return root;
    }

}