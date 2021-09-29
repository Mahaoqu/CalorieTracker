package edu.ncsu.calorietracker.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import edu.ncsu.calorietracker.db.entity.User;

@Dao
public interface UserDao {
    @Query("SELECT * from User WHERE id = :id")
    public User getUser(int id);

    @Query("SELECT * FROM user WHERE id = :id")
    public LiveData<User> loadUserById(int id);

    @Query("SELECT id from User WHERE username = :username")
    public int getUser(String username);

    @Query("SELECT COUNT(username) from User")
    public int userCount();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);
}
