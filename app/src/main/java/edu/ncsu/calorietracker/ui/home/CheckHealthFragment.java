package edu.ncsu.calorietracker.ui.home;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentCheckHealthBinding;
import edu.ncsu.calorietracker.db.AppDatabase;
import edu.ncsu.calorietracker.db.entity.User;
import edu.ncsu.calorietracker.viewmodel.HomeViewModel;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;


public class CheckHealthFragment extends Fragment {
    private HomeViewModel homeViewModel;

    FragmentCheckHealthBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentCheckHealthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getBMI().observe(getViewLifecycleOwner(), res -> {
            if (res == null) {
                MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(requireContext());
                dialog.setMessage("Please update your profile!");
                dialog.show();
            } else {
                Resources r = getResources();
                binding.userBMI.setText(String.format(r.getString(R.string.bmi_fmt), res.bmi));
                binding.health.setText(String.format(r.getString(R.string.bmi_status), getWeightStatus(res.bmi)));
                binding.weightBetween.setText(String.format(r.getString(R.string.weigh_between_text), res.lowerHealthBMI, res.higherHealthBMI));
            }
        });

        return root;
    }

    private String getWeightStatus(int bmi) {
        if (bmi >= 30.0) return "obese";
        else if (bmi >= 25.5 && bmi <= 29.9) return "overweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "healthy";
        else return "underweight";
    }
}