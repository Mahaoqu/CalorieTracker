package edu.ncsu.calorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private Button b1;
    Button button;
    EditText Input1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        Input1 = (EditText) findViewById(R.id.editInput1);
        Input1.getText().toString();
        text1 = (TextView) findViewById(R.id.editInput1);
        text1.setText("Your calories are:"+text1.getText().toString());
    }
}