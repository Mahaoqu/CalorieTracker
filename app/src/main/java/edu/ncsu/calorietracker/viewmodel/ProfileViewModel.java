package edu.ncsu.calorietracker.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import edu.ncsu.calorietracker.db.entity.User;
import edu.ncsu.calorietracker.repository.UserRepository;

public class ProfileViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private MutableLiveData<User> user;

    public ProfileViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User> getInitUser() {
        return userRepository.getUserById(1);
    }

    public void setUser(User user) {
        user.setId(1);
        userRepository.setUser(user);
    }
}