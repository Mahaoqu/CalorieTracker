package edu.ncsu.calorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    Button submitB;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        //Input1 = (EditText) findViewById(R.id.editInput1);
        //Input1.getText().toString();
        //text1 = (TextView) findViewById(R.id.editInput1);
        //text1.setText("Your calories are:"+text1.getText().toString());
        this.calories_input = (EditText) findViewById(R.id.editInput1);
        this.weight_input = (EditText) findViewById(R.id.editInput2);
        this.gender_input = (EditText)findViewById(R.id.editInput3);
        this.height_input = (EditText)findViewById(R.id.editInput4);
        this.age_input = (EditText)findViewById(R.id.editInput5);
        submitB = (Button) findViewById(R.id.submitButton);
        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_calories = Integer.valueOf(calories_input.getText().toString());
                user_weight = Integer.valueOf(weight_input.getText().toString());
                user_gender = gender_input.getText().toString();
                user_height = Integer.valueOf(height_input.getText().toString());
                user_age = Integer.valueOf(age_input.getText().toString());

                //TODO
                // to calculate if the user is healthy


            }
        });
    }
}