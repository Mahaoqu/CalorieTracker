package edu.ncsu.calorietracker.ui.notifications;

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
import edu.ncsu.calorietracker.db.MealRoomDatabase;
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    // Database
    private UserDatabase mUserDb;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Initializing database
        mUserDb = UserDatabase.getInstance(this.getContext());

        // This is how to create a user
        // User user = new User("Rob", "150", "Male", "180", "30");
        /// mUserDb.userDao().insertUser(user);

        // This is how to update a user. Make sure to set the user's id to 1 to update the correct user and not insert a new one
        // user.setWeight("149");
        // user.setId(1);
        // mUserDb.userDao().updateUser(user);

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

        // This is how to get the user, since we only have one user using app, it's id is 1
        User user = mUserDb.userDao().getUser(1);

        final TextView nameView = binding.nameTextView;
        notificationsViewModel.setName(user.getUsername());
        notificationsViewModel.getName().observe(getViewLifecycleOwner(), nameView::setText);

        final TextView weightView = binding.weightTextView;
        notificationsViewModel.setWeight(user.getWeight());
        notificationsViewModel.getWeight().observe(getViewLifecycleOwner(), weightView::setText);

        final TextView genderView = binding.genderTextView;
        notificationsViewModel.setGender(user.getGender());
        notificationsViewModel.getGender().observe(getViewLifecycleOwner(), genderView::setText);

        final TextView heightView = binding.heightTextView;
        notificationsViewModel.setHeight(user.getHeight());
        notificationsViewModel.getHeight().observe(getViewLifecycleOwner(), heightView::setText);

        final TextView ageView = binding.ageTextView;
        notificationsViewModel.setAge(user.getAge());
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