package edu.ncsu.calorietracker.ui.notifications;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.databinding.FragmentNotificationsBinding;
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;


public class EditUserProfileFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentEditUserProfileBinding binding;




    public EditUserProfileFragment() {
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

        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button mbt_edit = (Button)binding.btEditProfile;
        TextView nameView = binding.a;
        TextView weightView = binding.b;
        TextView genderView = binding.c;
        TextView heightView = binding.d;
        TextView ageView = binding.e;

        notificationsViewModel.setName(nameView.toString());
        //notificationsViewModel.getName().observe(getViewLifecycleOwner(), nameView::setText);
        notificationsViewModel.setWeight(weightView.toString());
        notificationsViewModel.setGender(genderView.toString());
        notificationsViewModel.setHeight(heightView.toString());
        notificationsViewModel.setAge(ageView.toString());

        mbt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Navigation.findNavController(view).navigate(R.layout.fragment_notifications);
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