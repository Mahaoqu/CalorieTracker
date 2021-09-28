package edu.ncsu.calorietracker.ui.notifications;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.databinding.FragmentNotificationsBinding;
import edu.ncsu.calorietracker.viewmodel.NotificationsViewModel;


public class EditUserProfileFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentEditUserProfileBinding binding;

    String nameView;
    String weightView;
    String genderView;
    String heightView;
    String ageView;

    public EditUserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //notificationsViewModel =
        //new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Button mbt_edit = binding.updateProfile;
        mbt_edit.setOnClickListener(
                view -> {
                    nameView = binding.nameEt.getText().toString();
                    weightView = binding.weightEt.getText().toString();
                    genderView = binding.genderEt.getText().toString();
                    heightView = binding.heightEt.getText().toString();
                    ageView = binding.ageEt.getText().toString();


                    //TODO: save user data to database


                    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(getContext());
                    if (nameView.equals("") || weightView.equals("") || genderView.equals("") || heightView.equals("") || ageView.equals("")) {
                        dialog.setMessage("not complete");
                        dialog.show();
                    } else {
                        Navigation.findNavController(view).navigate(R.id.navigation_notifications);
                    }


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