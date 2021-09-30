package edu.ncsu.calorietracker;

import org.junit.Test;

import static org.junit.Assert.*;

import androidx.navigation.Navigation;

import java.util.Objects;

import edu.ncsu.calorietracker.databinding.FragmentEditUserProfileBinding;
import edu.ncsu.calorietracker.db.entity.Meal;
import edu.ncsu.calorietracker.db.entity.User;
import edu.ncsu.calorietracker.ui.profile.EditUserProfileFragment;
import edu.ncsu.calorietracker.ui.profile.ProfileFragment;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CaloriesTrackerUnitTest extends EditUserProfileFragment {

    ProfileViewModel profileViewModel;
    ProfileFragment binding;

    @Test
    public void userCheck() throws Exception{

        //initialize a user
        User user = new User("", "", "", "", "");

        // Check if there is any value after we set.
        assertNotNull(user.getUsername());
        assertNotNull(user.getWeight());
        assertNotNull(user.getGender());
        assertNotNull(user.getHeight());
        assertNotNull(user.getAge());

        // update user info
        user.setUsername("Default");
        user.setWeight("123");
        user.setGender("Female");
        user.setHeight("321");
        user.setAge("50");

        // Check if the database work correctly.
        assertEquals(user.getUsername(), "Default");
        assertEquals(user.getWeight(), "123");
        assertEquals(user.getGender(), "Female");
        assertEquals(user.getHeight(), "321");
        assertEquals(user.getAge(), "50");
    }

    @Test
    public void editProfileCheck() throws Exception {
        User user = new User("default", "default",
                "default", "default", "default");

        user.setUsername("Default");
        user.setWeight("123");
        user.setGender("Female");
        user.setHeight("321");
        user.setAge("50");

        EditUserProfileFragment epf = new EditUserProfileFragment();
        assertEquals(user.getUsername(), "Default");
    }

    @Test
    public void DashboardTest() throws Exception{
        Meal meal = new Meal("egg", 1);

        assertNotNull(meal.getCalorie());
        assertNotNull(meal.getMealName());

        assertEquals(meal.getMealName(), "egg");
        assertEquals(meal.getCalorie(), 1);

        // test update
        meal.setMealName("rice");
        meal.setCalorie(100);

        assertNotEquals(meal.getMealName(), "egg");
        assertNotEquals(meal.getCalorie(), 1);
        assertEquals(meal.getCalorie(), 100);
        assertEquals(meal.getMealName(), "rice");
    }

}
