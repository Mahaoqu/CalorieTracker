package edu.ncsu.calorietracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentHomeBinding;
import edu.ncsu.calorietracker.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btCheckhealth.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.checkHealthFragment, null));
        binding.btCal.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.calMainFragment, null));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}