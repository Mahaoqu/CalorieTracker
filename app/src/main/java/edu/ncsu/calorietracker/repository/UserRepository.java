package edu.ncsu.calorietracker.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import edu.ncsu.calorietracker.db.AppDatabase;
import edu.ncsu.calorietracker.db.dao.UserDao;
import edu.ncsu.calorietracker.db.entity.User;

public class UserRepository {
    public UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.userDao();
    }

    public LiveData<User> getUserById(int id) {
        return userDao.loadUserById(id);
    }

    public void setUser(User user) {
        AppDatabase.databaseWriteExecutor.execute(() -> userDao.insertUsers(user));
    }
}
