package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int salary = 33600;
    double tssDeduction = 0;
    double lawDeduction = 0;
    double realSalary = 0;

    public void calculate(View view) {
       tssDeduction = tssCalculator(salary);
   //    lawDeduction = lawCalculator(salary);
    //   realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);

       displayTssDeduction(tssDeduction);
    }

    private void displayTssDeduction(double tssDeductionDisplay) {
        String tssDeductionDisplayString = new Double(tssDeductionDisplay).toString();
        TextView tssDeductionTextView = (TextView)
                findViewById(R.id.tss_text_view);
        tssDeductionTextView.setText(tssDeductionDisplayString);
    }

    private double tssCalculator(double monthlyMoney) {
        return (monthlyMoney * 0.0591);
    }
/*
    private double lawCalculator(int monthlyMoney){

        int moneyPerYear = monthlyMoney * 12;
        double deductionByLaw;

        if (moneyPerYear < 416220) {
            deductionByLaw = 0;
        }

        else if (moneyPerYear >= 416220 && moneyPerYear < 624329) {
            deductionByLaw = (moneyPerYear - 416220)*0.15;
        }

        else if (moneyPerYear >= 624329 && moneyPerYear < 867123) {
            deductionByLaw = 31216 + (moneyPerYear - 624329)*0.20;
        }
        else deductionByLaw = 79776 + (moneyPerYear - 867123)*0.25;



        return deductionByLaw;

    }

    private double realSalaryCalculator(int monthlyMoney, double deductionByTss, double deductionByLaw){
        return  monthlyMoney - deductionByLaw - deductionByTss;
    }
*/




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