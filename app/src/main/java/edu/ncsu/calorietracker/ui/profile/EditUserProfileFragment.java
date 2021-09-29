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
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;


public class EditUserProfileFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentEditUserProfileBinding binding;

    public String nameView;
    public String weightView;
    public String genderView;
    public String heightView;
    public String ageView;


    private AppDatabase mUserDb;

    public EditUserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mUserDb = AppDatabase.getInstance(this.getContext());
        User user = new User(nameView, weightView, genderView, heightView, ageView);
        mUserDb.userDao().insertUser(user);
        user.setId(1);
        mUserDb.userDao().updateUser(user);
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button edit = binding.updateProfile;


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nameView = binding.nameEt.getText().toString();
                weightView = binding.weightEt.getText().toString();
                genderView = binding.genderEt.getText().toString();
                heightView = binding.heightEt.getText().toString();
                ageView = binding.ageEt.getText().toString();

                MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getContext());
                if (nameView.equals("") || weightView.equals("") || genderView.equals("") || heightView.equals("") || ageView.equals("")) {
                    dialog.setMessage("not complete");
                    dialog.show();
                } else {
                    User user = mUserDb.userDao().getUser(1);
                    user.setAge(ageView);
                    user.setHeight(heightView);
                    user.setWeight(weightView);
                    user.setGender(genderView);
                    user.setUsername(nameView);
                    user.setId(1);
                    mUserDb.userDao().updateUser(user);
                    Navigation.findNavController(view).navigate(R.id.navigation_notifications);
                }
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