package edu.ncsu.calorietracker;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.ncsu.calorietracker.CalCaloriesPage.CalMainActivity;
import edu.ncsu.calorietracker.CheckHealthPage.TextViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mbt_textView;
    private Button mbt_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mbt_textView = (Button) findViewById(R.id.bt_textview);
        this.mbt_cal = (Button) findViewById(R.id.bt_cal) ;
        /**
        mbt_textView.setBackgroundColor(Color.WHITE);
        mbt_textView.setTextColor(Color.BLACK);
        mbt_cal.setBackgroundColor(Color.WHITE);
        mbt_cal.setTextColor(Color.BLACK);
         */
        this.mbt_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jump to new page (TextView)
                Intent i = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(i);
            }
        });
        this.mbt_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jump to new page (TextView)
                Intent i = new Intent(MainActivity.this, CalMainActivity.class);
                startActivity(i);
            }
        });
    }
}