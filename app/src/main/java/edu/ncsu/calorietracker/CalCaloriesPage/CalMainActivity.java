package edu.ncsu.calorietracker.CalCaloriesPage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.ncsu.calorietracker.R;
import edu.ncsu.calorietracker.databinding.ActivityCalMainBinding;

public class CalMainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener{

    private Button btn_increase;
    private Button btn_decrease;
    private EditText amount;
    private Button btn_submit;
    private int sum=0;
    private int user_calories = 0;
    private float x_submit = 100;
    private float y_submit = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCalMainBinding binding = ActivityCalMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
//        binding.etAmount

        amount = (EditText) findViewById(R.id.et_amount);
        this.btn_submit = (Button) findViewById(R.id.bt_cal) ;
        this.btn_increase = (Button) findViewById(R.id.btn_increase);
        this.btn_decrease = (Button) findViewById(R.id.btn_decrease);

        this.btn_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum++;
                amount.setText(sum+"");
                amount.setVisibility(View.VISIBLE);
                btn_decrease.setVisibility(View.VISIBLE);
            }
        });
        this.btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sum>0){
                    sum--;
                    amount.setText(sum+"");
                    amount.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(editable.toString()==null)
            return;
        sum = Integer.valueOf(editable.toString());
        if(sum > 10){
            amount.setText("10");
            return;
        }
    }

    public int getSum(){
        return sum;
    }

    @Override
    public void onClick(View view) {

    }
}