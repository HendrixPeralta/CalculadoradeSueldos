package com.hdxperalta.calculadoradesueldos;

import android.annotation.SuppressLint;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    double salary = 61000;
    double tssDeduction = 0;
    double lawDeduction = 0;
    double realSalary = 0;

    double save = 0;
    double debt = 0;
    double expend = 0;

    public void calculate(View view) {
       tssDeduction = tssCalculator(salary);
       lawDeduction = lawCalculator(salary);
       realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);

       save = savingsCalculator(realSalary);
       debt = debtsCalculator(realSalary);
       expend = expensesCalculator(realSalary);

       displayTssDeduction(tssDeduction);
       displayLawDeduction(lawDeduction);
       displayRealSalary(realSalary);

       displayMoneyToSave(save);
       displayMoneyToDebt(debt);
       displayMoneyToExpend(expend);

    }

    /*
    * IT WORKS
    *
    * this method display the money available to EXPEND on screen
    * */
    private void displayMoneyToExpend(double expend) {
        String expendString = doubleToCurrency(expend);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.expend_text_view);
        tssDeductionTextView.setText(expendString);
    }

    /*
    * IT WORKS
    *
    * this method display the money available to DEBT on screen
    * */
    private void displayMoneyToDebt(double debt) {
        String debtString = doubleToCurrency(debt);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.debts_text_view);
        tssDeductionTextView.setText(debtString);
    }

    /*
    * IT WORKS
    *
    * this method display the money available to SAVE on screen
    * */
    private void displayMoneyToSave(double save) {
        String saveString = doubleToCurrency(save);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.savings_text_view);
        tssDeductionTextView.setText(saveString);
    }

    /*
    * IT WORKS
    *
    * Return 60% of realSalary
    * */
    private double expensesCalculator(double realSalary) {
        return realSalary * 0.6;
    }

    /*
    * IT WORKS
    *
    * Return 30% of realSalary
    * */
    private double debtsCalculator(double realSalary) {
        return realSalary * 0.3;
    }

    /*
    * IT WORKS
    *
    * Return 10% of realSalary
    * */
    private double savingsCalculator(double realSalary) {
        return realSalary * 0.1;
    }

    /*
    * IT WORKS
    *
    * Generate a String on money format from a double
    * */
    public String doubleToCurrency(double doubleToConvert){
        return NumberFormat.getCurrencyInstance().format(doubleToConvert);

    }
    /*
    * IT WORKS
    *
    * this method display the REAL SALARY on screen
    * */
    private void displayRealSalary(double realSalary) {
        String tssDeductionDisplayString = doubleToCurrency(realSalary);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.real_salary_text_view);
        tssDeductionTextView.setText(tssDeductionDisplayString);
    }

    /*
    * IT WORKS
    *
    * this method display the LAW deduction on screen
    * */
    private void displayLawDeduction(double lawDeductionDisplay) {
        String tssDeductionDisplayString = doubleToCurrency(lawDeductionDisplay);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.law_text_view);
        tssDeductionTextView.setText(tssDeductionDisplayString);
    }

    /*
   * IT WORKS
   *
   * this method display the TSS deduction on screen
   * */
    private void displayTssDeduction(double tssDeductionDisplay) {
        String tssDeductionDisplayString = doubleToCurrency(tssDeductionDisplay);
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.tss_text_view);
        tssDeductionTextView.setText(tssDeductionDisplayString);
    }

    /*
   * IT WORKS
   *
   * this method CALCULATE the TSS deduction
   * */
    private double tssCalculator(double monthlyMoney) {
        return (monthlyMoney * 0.0592);
    }

    /*
   * IT WORKS
   *
   * this method CALCULATE the LAW deduction
   * */
    private double lawCalculator(double monthlyMoney){

        double moneyPerYear = monthlyMoney * 12;
        double deductionByLaw;

        if (moneyPerYear < 416220) {
            deductionByLaw = 0;
        }

        else if (moneyPerYear >= 416220 && moneyPerYear < 624329) {
            deductionByLaw = ((moneyPerYear - 416220) * 0.15) / 12;

        }

        else if (moneyPerYear >= 624329 && moneyPerYear < 867123) {
            deductionByLaw = (31216 + (moneyPerYear - 624329) * 0.20) / 12;
        }
        else deductionByLaw = (79776 + (moneyPerYear - 867123) * 0.25) / 12;

        return deductionByLaw;
    }

    /*
   * IT WORKS
   *
   * this method CALCULATE the REAL SALARY
   * */
    private double realSalaryCalculator(double monthlyMoney, double deductionByTss, double deductionByLaw){
        return  monthlyMoney - deductionByLaw - deductionByTss;
    }





}





















//-----------------------------------------------------------------------------------------------------------------------

/*



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


     // This method is called when the order button is clicked.


    int quantity = 0;

    public void submitOrder(View view) {
        int price = calculatePrice(quantity, 5);
        displayMessage(createOrderSummary(price));
    }

    public void increment(View view){
        quantity +=1;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity -=1;
        displayQuantity(quantity);
    }

    // * This method return a summary string

    public String createOrderSummary(int totalPrice){
        return "Name: Hendrix Peralta" +
                "\nQuantity: " + quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(totalPrice)  +
                "\nThank you";
    }


    // * This method calculate and return the total price of the order.

    public int calculatePrice (int numberOfCoffees, int price){
        return numberOfCoffees * price;
    }


    // * This method displays the given quantity value on the screen.

    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView)
                findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


    // * This method displays the given text on the screen.

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView)
                findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
 */