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

    private UserRepository userRepository;
    private MutableLiveData<User> user;

    public ProfileViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User> getInitUser() {
        // User defaultUser = new User("Default", "150", "Male", "180", "30");

        // This is how you insert a new user

        // defaultUser.setId(2);
        // mUserDb.userDao().insertUser(defaultUser);

        // Checks if there is already user data
        // If not, insert a default user data
//        User user = mUserDb.userDao().getUser(1);
//        if(user == null) {
//            defaultUser.setId(1);
//            mUserDb.userDao().insertUser(defaultUser);
//        }

        return Transformations.map(userRepository.getUserById(1),
                user -> {
                    if (user == null) {
                        return new User("Default", "150", "Male", "180", "30");
                    }
                    return user;
                }
        );
    }

    public void setUser(User user) {
        user.setId(1);
        userRepository.setUser(user);
    }
}