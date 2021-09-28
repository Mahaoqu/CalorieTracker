package edu.ncsu.calorietracker.ui.dashboard;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import edu.ncsu.calorietracker.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

import edu.ncsu.calorietracker.databinding.FragmentDashboardBinding;
import edu.ncsu.calorietracker.db.Meal;
import edu.ncsu.calorietracker.viewmodel.DashboardViewModel;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btn.setOnClickListener(view -> {
            new MaterialAlertDialogBuilder(getContext())
                    .setTitle("Calorie：")
                    .setView(R.layout.input_cal)
                    .setPositiveButton(
                            "ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    TextView input = ((AlertDialog) dialog).findViewById(android.R.id.text1);
                                    Toast.makeText(getContext(), input.getText(), Toast.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton("cancel", null)
                    .show();
        });


        final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.submitList(new ArrayList<Meal>(){{
            add(new Meal("breakfast",200));
            add(new Meal("lunch",800));
            add(new Meal("dinner",500));
        }});

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}