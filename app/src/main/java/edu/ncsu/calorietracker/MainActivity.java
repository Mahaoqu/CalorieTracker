package edu.ncsu.calorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.ncsu.calorietracker.CheckHealthPage.TextViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mbt_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mbt_textView = (Button) findViewById(R.id.bt_textview);
        this.mbt_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // jump to new page (TextView)
                Intent i = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(i);
            }
        });
    }
}