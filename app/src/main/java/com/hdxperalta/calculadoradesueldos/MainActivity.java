package com.hdxperalta.calculadoradesueldos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button myCalculateButton = (Button)
                findViewById(R.id.calculate_button);
        Button myClearButton = (Button)
                findViewById(R.id.clear_data_button);

        myCalculateButton.setOnClickListener(this);
        myClearButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calculate_button:
                EditText salaryEditText = (EditText) findViewById(R.id.salary_edit_text);
                String salaryString = salaryEditText.getText().toString();
                salary = Integer.parseInt(salaryString);


                Intent goToDataViewer =
                        new Intent(this, DataViewerActivity.class);
                startActivity(goToDataViewer);


            case R.id.clear_data_button:
                Toast.makeText(this, "Presionaste Borrar", Toast.LENGTH_SHORT);
        }
    }
}
