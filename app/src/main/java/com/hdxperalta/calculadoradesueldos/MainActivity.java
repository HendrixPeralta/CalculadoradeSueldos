package com.hdxperalta.calculadoradesueldos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity
        extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myCalculateButton = (Button)
                findViewById(R.id.input_view_button);

        myCalculateButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.input_view_button:
                Log.d("MainActivity", "button clicked");
                Intent goToInputView =
                        new Intent(this, DataColectorActivity.class);
                startActivity(goToInputView);
                break;
        }

    }
}
