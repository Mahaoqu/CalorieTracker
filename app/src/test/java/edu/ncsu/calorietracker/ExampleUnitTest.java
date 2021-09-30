package edu.ncsu.calorietracker;

import org.junit.Test;

import static org.junit.Assert.*;

import edu.ncsu.calorietracker.db.entity.User;
import edu.ncsu.calorietracker.ui.profile.ProfileFragment;
import edu.ncsu.calorietracker.viewmodel.ProfileViewModel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends  ProfileFragment{

    ProfileViewModel profileViewModel;
    ProfileFragment binding;
    
    @Test
    public void databaseCheck() throws Exception{

        //initialize a user
        User user = new User("", "", "", "", "");
        user.setUsername("Default");
        user.setWeight("123");
        user.setGender("Female");
        user.setHeight("321");
        user.setAge("50");

        // Check if there is any value after we set.
        assertNotNull(user.getUsername());
        assertNotNull(user.getWeight());
        assertNotNull(user.getGender());
        assertNotNull(user.getHeight());
        assertNotNull(user.getAge());

        // Check if the database work correctly.
        assertEquals(user.getUsername(), "Default");
        assertEquals(user.getWeight(), "123");
        assertEquals(user.getGender(), "Female");
        assertEquals(user.getHeight(), "321");
        assertEquals(user.getAge(), "50");
    }

    @Test
    public void editProfileCheck() throws Exception {

    }

}
