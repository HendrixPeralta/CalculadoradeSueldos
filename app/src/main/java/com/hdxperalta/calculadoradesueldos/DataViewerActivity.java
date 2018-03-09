package com.hdxperalta.calculadoradesueldos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class DataViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);

        int salary = getIntent().getIntExtra("SALARY", 0);
        int fixedExpenses = getIntent().getIntExtra("EXPENSES", 0);
        int variableExpenses = getIntent().getIntExtra("VARIABLE_EXPENSES", 0);



        Math UserData = new Math(salary, fixedExpenses, variableExpenses);

        //aqui puse fixed
        double expendMoneyLeft = UserData.expensesLimit - fixedExpenses;

        if (expendMoneyLeft < UserData.expensesLimit){
            showExpendAlert(expendMoneyLeft);
        }

        displayRealSalary(UserData.realSalary);
        displayLawDeduction(UserData.lawDeduction);
        displayTssDeduction(UserData.tssDeduction);
        displaySavingsLimit(UserData.savingsLimit);
        displayDebtsLimit(UserData.debtsLimit);
        displayExpensesLimit(UserData.expensesLimit);
        //aqui puse fixed
        displayNormalExpenses(fixedExpenses);
        displayExpendMoneyLeft(expendMoneyLeft);
    }

    private void showExpendAlert(double expendMoneyLeft) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("GASTOS EXCEDIDOS")
                .setMessage("Tus gastos exceden el limite propuesto")
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .create();
        alertDialog.show();
    }
    private void displayExpendMoneyLeft(double expendMoneyLeft) {
        String expendMoneyLeftString = numberToCurrency(expendMoneyLeft);
        TextView expendMoneyLeftTextView = (TextView)
                findViewById(R.id.expendMoneyLeftTexView);
        if (expendMoneyLeft < 0){
            expendMoneyLeftTextView.setTextColor(Color.parseColor("#c62535"));

        }
        expendMoneyLeftTextView.setText(expendMoneyLeftString);

    }
    private void displayNormalExpenses(int expenses) {
        String normalExpenses = numberToCurrency(expenses);
        TextView normalExpensesTextView = (TextView)
                findViewById(R.id.normal_expenses_text_view);
        normalExpensesTextView.setText(normalExpenses);
    }
    private void displayExpensesLimit(double expensesLimit) {
        String expensesString = numberToCurrency(expensesLimit);
        TextView expensesTextView = (TextView)
                findViewById(R.id.expenses_limit_text_view);
        expensesTextView.setText(expensesString);
    }
    private void displayDebtsLimit(double debtsLimit) {
        String debtString = numberToCurrency(debtsLimit);
        TextView debtTextView = (TextView)
                findViewById(R.id.debts_limit_text_view);
        debtTextView.setText(debtString);
    }
    private void displaySavingsLimit(double savingsLimit) {
        String savingString = numberToCurrency(savingsLimit);
        TextView savingTextView = (TextView)
                findViewById(R.id.savings_limit_text_view);
        savingTextView.setText(savingString);
    }
    private void displayTssDeduction(double tssDeduction) {
        String tssDeductionString = numberToCurrency(tssDeduction);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.tss_text_view);
        tssDeductionTextView.setText(tssDeductionString);
    }
    private void displayLawDeduction(double lawDeduction) {
        String lawDeductionString = numberToCurrency(lawDeduction);
        TextView lawDeductionTextView = (TextView)
                findViewById(R.id.law_deduction_text_view);
        lawDeductionTextView.setText(lawDeductionString);
    }
    private void displayRealSalary(double realSalary) {
        String realSalaryString = numberToCurrency(realSalary);
        TextView realSalaryTextView = (TextView)
                findViewById(R.id.real_salary_text_view);
        realSalaryTextView.setText(realSalaryString);
    }

    public static String numberToCurrency(double doubleToConvert){
        return NumberFormat.getCurrencyInstance().format(doubleToConvert);

    }

}