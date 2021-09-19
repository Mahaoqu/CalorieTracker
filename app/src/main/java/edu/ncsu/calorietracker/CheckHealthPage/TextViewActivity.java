package edu.ncsu.calorietracker.CheckHealthPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.ncsu.calorietracker.R;

public class TextViewActivity extends AppCompatActivity {

    private Button submitB;
    EditText calories_input;
    EditText weight_input;
    EditText height_input;
    EditText gender_input;
    EditText age_input;
    int user_weight;
    int user_calories;
    String user_gender;
    int user_age;
    int user_height;
    double standardCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        this.calories_input = (EditText) findViewById(R.id.editInput1);
        this.weight_input = (EditText) findViewById(R.id.editInput2);
        this.gender_input = (EditText) findViewById(R.id.editInput3);
        this.height_input = (EditText) findViewById(R.id.editInput4);
        this.age_input = (EditText) findViewById(R.id.editInput5);
        submitB = (Button) findViewById(R.id.submitButton);
        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_calories = Integer.valueOf(calories_input.getText().toString());
                user_weight = Integer.valueOf(weight_input.getText().toString());
                user_gender = gender_input.getText().toString();
                user_height = Integer.valueOf(height_input.getText().toString());
                user_age = Integer.valueOf(age_input.getText().toString());

                standardCalories = getStandardCalories(user_weight, user_gender, user_height, user_age);
                //TODO
                /**
                 * to calculate if the user is healthy
                 * The formula is:
                 * Adult male: 66 + (6.3 x body weight in lbs.) + (12.9 x height in inches) - (6.8 x age in years) = BMR
                 * Adult female: 655 + (4.3 x weight in lbs.) + (4.7 x height in inches) - (4.7 x age in years) = BMR
                 */
                if(standardCalories == -1){
                    Intent i = new Intent(TextViewActivity.this, ErrorActivity.class);
                    startActivity(i);
                }
                else if(user_calories <= standardCalories){
                    Intent i = new Intent(TextViewActivity.this, HealthyActivity.class);
                    startActivity(i);
                }else{
                    Intent i = new Intent(TextViewActivity.this, UnhealthyActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private double getStandardCalories (int weight, String gender, int height, int age){
        if (user_gender.equals("male") || user_gender.equals("Male") || user_gender.equals("MALE")) {
            return 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
        }else if(user_gender.equals("female") || user_gender.equals("Female") || user_gender.equals("FEMALE")){
            return 655+(4.3*weight)+(4.7*height)-(4.7*age);
        }else{
            return -1;
        }
    }

}