package edu.ncsu.calorietracker.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.ActivityMainNavBinding;
import edu.ncsu.calorietracker.databinding.FragmentNotificationsBinding;
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button edit = binding.btEditProfile;
        // final TextView textView = binding.tvProfile;
        // notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        final TextView nameView = binding.nameTextView;
        notificationsViewModel.setName("Rob");
        notificationsViewModel.getName().observe(getViewLifecycleOwner(), nameView::setText);

        final TextView weightView = binding.weightTextView;
        notificationsViewModel.setWeight("150");
        notificationsViewModel.getWeight().observe(getViewLifecycleOwner(), weightView::setText);

        final TextView genderView = binding.genderTextView;
        notificationsViewModel.setGender("Male");
        notificationsViewModel.getGender().observe(getViewLifecycleOwner(), genderView::setText);

        final TextView heightView = binding.heightTextView;
        notificationsViewModel.setHeight("160");
        notificationsViewModel.getHeight().observe(getViewLifecycleOwner(), heightView::setText);

        final TextView ageView = binding.ageTextView;
        notificationsViewModel.setAge("21");
        notificationsViewModel.getAge().observe(getViewLifecycleOwner(), ageView::setText);


        edit.setOnClickListener(
                view -> Navigation.findNavController(view).navigate(R.id.editUserProfileFragment)
        );
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}