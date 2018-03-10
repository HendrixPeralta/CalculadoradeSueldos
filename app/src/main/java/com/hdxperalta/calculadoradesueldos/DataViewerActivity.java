package com.hdxperalta.calculadoradesueldos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
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

        int salary = getIntent().getIntExtra("SALARY", 0);
        int fixedExpenses = getIntent().getIntExtra("FIXED_EXPENSES", 0);
        int variableExpenses = getIntent().getIntExtra("VARIABLE_EXPENSES", 0);

        Math UserData = new Math(salary, fixedExpenses, variableExpenses);

        if (UserData.expensesLimit < (fixedExpenses + variableExpenses)){
            showExpendAlert(UserData.expensesLimit);
        }

        displayOnDataViewer(UserData.realSalary, R.id.real_salary_text_view);
        displayOnDataViewer(UserData.lawDeduction, R.id.law_deduction_text_view);
        displayOnDataViewer(UserData.tssDeduction, R.id.tss_text_view);
        displayOnDataViewer(UserData.savingsLimit, R.id.savings_limit_text_view);
        displayOnDataViewer(UserData.debtsLimit, R.id.debts_limit_text_view);
        displayOnDataViewer(UserData.expensesLimit, R.id.expenses_limit_text_view);
        displayOnDataViewer(fixedExpenses, R.id.fixedExpensesTextView);
        displayOnDataViewer(variableExpenses, R.id.variableExpensesTextView);
        displayOnDataViewer(UserData.availableMoney, R.id.availableTextView);
    }

    private void showExpendAlert(double expendLimit) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("GASTOS EXCEDIDOS")
                .setMessage("Tus gastos exceden el limite propuesto de: " + numberToCurrency(expendLimit))
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create();
        alertDialog.show();
    }
    private void displayOnDataViewer(double number, int viewID) {
        String numberCurrency = numberToCurrency(number);
        TextView dataViewerTextView = (TextView)
                findViewById(viewID);
        dataViewerTextView.setText(numberCurrency);
    }
    public static String numberToCurrency(double doubleToConvert){
        return NumberFormat.getCurrencyInstance().format(doubleToConvert);

    }


//    private void displayExpendMoneyLeft(double expendMoneyLeft) {
//        String expendMoneyLeftString = numberToCurrency(expendMoneyLeft);
//        TextView expendMoneyLeftTextView = (TextView)
//                findViewById(R.id.variableExpensesTextView);
//        if (expendMoneyLeft < 0){
//            expendMoneyLeftTextView.setTextColor(Color.parseColor("#c62535"));
//
//        }
//        expendMoneyLeftTextView.setText(expendMoneyLeftString);
//
//    }

}