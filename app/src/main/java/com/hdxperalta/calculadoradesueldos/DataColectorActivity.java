package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DataColectorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_colector);

        Button myCalculateButton = (Button)
                findViewById(R.id.calculate_button);

        myCalculateButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calculate_button:


                EditText inputSalary = (EditText)
                        findViewById(R.id.salary_edit_text);
                String salaryString = inputSalary.getText().toString();
                int salary = Integer.parseInt(salaryString);

                Math UserDataCalculation = new Math(salary);
//                Displayer DisplayUserInformation = new Displayer();
        }
    }
}
