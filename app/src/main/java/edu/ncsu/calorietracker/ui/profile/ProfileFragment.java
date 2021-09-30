package edu.ncsu.calorietracker.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.util.Locale;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentProfileBinding;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentProfileBinding binding;

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
            if (user == null) {
                binding.noUserTips.setVisibility(View.VISIBLE);
                binding.nameTextView.setText("");
                binding.weightTextView.setText("");
                binding.genderTextView.setText("");
                binding.heightTextView.setText("");
                binding.ageTextView.setText("");
            } else {
                binding.noUserTips.setVisibility(View.INVISIBLE);
                binding.nameTextView.setText("UserName:         " + user.getUsername().toUpperCase(Locale.ROOT));
                binding.weightTextView.setText("Weight:     " + user.getWeight() + " kg");
                binding.genderTextView.setText("Gender:     " + user.getGender());
                binding.heightTextView.setText("Height:     " + user.getHeight() + " cm");
                binding.ageTextView.setText("Age:   " + user.getAge());
            }
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