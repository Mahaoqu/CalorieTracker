package edu.ncsu.calorietracker.ui.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.db.AppDatabase;
import edu.ncsu.calorietracker.db.entity.User;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;


public class EditUserProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private FragmentEditUserProfileBinding binding;

    public EditUserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.updateProfile.setOnClickListener(view -> {

            String nameView = binding.nameEt.getText().toString();
            String weightView = binding.weightEt.getText().toString();
            String genderView = binding.genderEt.getText().toString();
            String heightView = binding.heightEt.getText().toString();
            String ageView = binding.ageEt.getText().toString();

            if (nameView.equals("") || weightView.equals("") || genderView.equals("") || heightView.equals("") || ageView.equals("")) {
                MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getContext());
                dialog.setMessage("not complete");
                dialog.show();
            } else {
                profileViewModel.setUser(new User(nameView, weightView, genderView, heightView, ageView));
                Navigation.findNavController(view).navigate(R.id.navigation_notifications);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}