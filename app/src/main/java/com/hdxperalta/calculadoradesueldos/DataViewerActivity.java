package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;

public class DataViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);

        int salary = MainActivity.getSalary();

        Math UserData = new Math(salary);

        displayRealSalary(UserData.realSalary);




    }

    private void displayRealSalary(double realSalary) {
        String realSalaryString = doubleToCurrency(realSalary);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.real_salary_text_view);
        tssDeductionTextView.setText(realSalaryString);
    }


    public String doubleToCurrency(double doubleToConvert){
        return NumberFormat.getCurrencyInstance().format(doubleToConvert);

    }

}