package edu.ncsu.calorietracker.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentProfileBinding;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    private FragmentProfileBinding binding;
    //public EditUserProfileFragment e;


    //String[] user_profile = new String[5];
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        profileViewModel.getInitUser().observe(getViewLifecycleOwner(), user -> {
            binding.nameTextView.setText(user.getUsername());
            binding.weightTextView.setText(user.getWeight());
            binding.genderTextView.setText(user.getGender());
            binding.heightTextView.setText(user.getHeight());
            binding.ageTextView.setText(user.getAge());
        });

        binding.btEditProfile.setOnClickListener(
                view -> {
                    Navigation.findNavController(view).navigate(R.id.editUserProfileFragment);
                }
        );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}