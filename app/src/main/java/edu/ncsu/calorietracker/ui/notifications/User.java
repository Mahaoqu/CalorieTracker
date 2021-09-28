package edu.ncsu.calorietracker.ui.notifications;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    // Only ever one user, so can use id = 1 to find the user
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "username")
    private String mUsername;

    @ColumnInfo(name = "weight")
    private String mWeight;

    @ColumnInfo(name = "gender")
    private String mGender;

    @ColumnInfo(name = "height")
    private String mHeight;

    @ColumnInfo(name = "age")
    private String mAge;

    public User(String username, String weight, String gender, String height, String age) {
        mUsername = username;
        mWeight = weight;
        mGender = gender;
        mHeight = height;
        mAge = age;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setWeight(String weight) {mWeight = weight;}

    public String getWeight() {
        return mWeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setAge(String age) {
        mAge = age;
    }

    public String getAge() {
        return mAge;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getGender() {
        return mGender;
    }
}