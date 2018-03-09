package com.hdxperalta.calculadoradesueldos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Serializable {


    private static final int REQUEST_CODE = 1;
    private static final int REQUEST_CODE2 = 2;

    private static int FIXED_EXPENSES = 0;
    private static int VARIABLE_EXPENSES = 0;
    private static int SALARY = 0;

    private ArrayList<String> fixedExpensesList = new ArrayList<String>();
    private ArrayList<String> variableExpensesLIst = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myCalculateButton = (Button)
                findViewById(R.id.calculate_button);
        Button myAddFixedExpensesButton = (Button)
                findViewById(R.id.addFixedExpensesButton);
        Button myShowFixedExpensesButton = (Button)
                findViewById(R.id.fixedExpensesButton);
        Button myAddVariableExpensesButton = (Button)
                findViewById(R.id.addVariableExpensesButton);
        Button myClearButton = (Button)
                findViewById(R.id.clearButton);
        Button myShowVariableExpensesButton = (Button)
                findViewById(R.id.variableExpensesButton);

        myCalculateButton.setOnClickListener(view ->{

            EditText salaryEditText = (EditText)
                    findViewById(R.id.salary_edit_text);
            String salaryString = salaryEditText.getText().toString();
            SALARY = Integer.parseInt(salaryString);

            Intent goToDataViewer =
                    new Intent(this,DataViewerActivity.class);
            goToDataViewer.putExtra("FIXED_EXPENSES", FIXED_EXPENSES);
            goToDataViewer.putExtra("SALARY", SALARY);
            startActivity(goToDataViewer);
        });
        myAddFixedExpensesButton.setOnClickListener(view ->{

            EditText expensesValueEditText = (EditText)
                    findViewById(R.id.FixedExpensesEditText);
            String expensesValueString = expensesValueEditText.getText().toString();
            expensesValueEditText.setText("");

            if (!expensesValueString.equals("")){

                fixedExpensesList.add(expensesValueString);

                int expensesValueInt = Integer.parseInt(expensesValueString);
                FIXED_EXPENSES += expensesValueInt;

                Toast toast = Toast.makeText(
                        this,
                        "Has anadido un gasto fijo de: " + expensesValueInt,
                        Toast.LENGTH_LONG);
                toast.show();

                for(int i = 0; i < fixedExpensesList.size();i++ ){
                    Log.v("MainActivity", "Fijos " + fixedExpensesList.get(i));
                }
            }
        });
        myShowFixedExpensesButton.setOnClickListener(view ->{

            Intent intent = new Intent(this, FixedExpensesListActivity.class);
            intent.putStringArrayListExtra("LIST_ITEMS", fixedExpensesList);
            startActivityForResult(intent, REQUEST_CODE);
        });
        myAddVariableExpensesButton.setOnClickListener(view ->{

            EditText expensesValueEditText = (EditText)
                    findViewById(R.id.variableExpensesEditText);
            String expensesValueString = expensesValueEditText.getText().toString();
            expensesValueEditText.setText("");

            if (!expensesValueString.equals("")){

                variableExpensesLIst.add(expensesValueString);

                int expensesValueInt = Integer.parseInt(expensesValueString);
                VARIABLE_EXPENSES += expensesValueInt;

                Toast toast = Toast.makeText(
                        this,
                        "Has anadido un gasto variable de: " + expensesValueInt,
                        Toast.LENGTH_SHORT);
                toast.show();

                for(int i = 0; i < variableExpensesLIst.size();i++ ){
                    Log.v("MainActivity", "Variable " + variableExpensesLIst.get(i));
                }
            }
        });
        myShowVariableExpensesButton.setOnClickListener(view ->{

            Intent intent = new Intent(this, FixedExpensesListActivity.class);
            intent.putStringArrayListExtra("LIST_ITEMS", variableExpensesLIst);
            startActivityForResult(intent, REQUEST_CODE2);

        });
        myClearButton.setOnClickListener(view ->{
            SALARY = 0;
            FIXED_EXPENSES = 0;
            fixedExpensesList = null;
        });

    }

    @Override
    public void onClick(View view) {}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case 1:
                Log.v("Main", "fixed expenses" + FIXED_EXPENSES);
                if(resultCode == RESULT_OK)
//                    if( resultCode == RESULT_OK && data != null) {
                        fixedExpensesList = data.getStringArrayListExtra("listItem");

                FIXED_EXPENSES = 0;
                for(int i = 0; i < fixedExpensesList.size(); i++){
                    FIXED_EXPENSES += Integer.parseInt(fixedExpensesList.get(i));
                }
                Log.v("Main", "fixed expenses" + FIXED_EXPENSES);
//                    }
                break;

            case 2:
                Log.v("Main", "fixed expenses" + VARIABLE_EXPENSES);
                if(resultCode == RESULT_OK)
//                    if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
                        variableExpensesLIst = data.getStringArrayListExtra("listItem");

                VARIABLE_EXPENSES = 0;
                for(int i = 0; i < variableExpensesLIst.size(); i++){
                    VARIABLE_EXPENSES += Integer.parseInt(variableExpensesLIst.get(i));
                }
                Log.v("Main", "fixed expenses" + VARIABLE_EXPENSES);
//                    }
                break;

            default:
                break;
        }
    }
}

