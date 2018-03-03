package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by hdx on 01/03/18.
 */

public class Math extends AppCompatActivity{

    public double tssDeduction = 0;
    public double lawDeduction = 0;
    public double realSalary = 0;

    public double expenses =13000;
    public double moneyAfterExpenses = 0;

    public double savingsLimit = 0;
    public double debtsLimit = 0;
    public double expensesLimit = 0;

//    public float porcentOfSavings;
//    public float porcentOfDebts;
//    public float porcentOfExpenses;


    public Math(int salary) {

        tssDeduction = tssDeductionCalculator(salary);

        lawDeduction = lawDeductionCalculator(salary);

        realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);

        moneyAfterExpenses = reminderMoneyCalculator(realSalary, expenses);

        savingsLimit = savingsLimitCalculator(moneyAfterExpenses);

        debtsLimit = debtsLimitCalculator(moneyAfterExpenses);

        expensesLimit = expensesLimitCalculator(moneyAfterExpenses);

        displayRealSalary(realSalary);
    }

    public double tssDeductionCalculator(double monthlyMoney) {
        return (monthlyMoney * 0.0592);
    }

    private double lawDeductionCalculator(double monthlyMoney){

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

    public double realSalaryCalculator(int monthlyMoney, double deductionByTss, double deductionByLaw){
        return  monthlyMoney - deductionByLaw - deductionByTss;
    }

    private double reminderMoneyCalculator(double realSalary, double expenses) {
        return realSalary - expenses;
    }

    private double savingsLimitCalculator(double moneyLeft) {
        return moneyLeft * 0.1;
    }

    private double debtsLimitCalculator(double moneyLeft) {
        return moneyLeft * 0.3;
    }

    private double expensesLimitCalculator(double moneyLeft) {
        return moneyLeft * 0.6;
    }

    public void displayRealSalary(double realSalary) {
        String tssDeductionDisplayString = numberToCurrency(realSalary);
    }

    private String numberToCurrency(double doubleToConvert){
        return NumberFormat.getCurrencyInstance().format(doubleToConvert);

    }
}
