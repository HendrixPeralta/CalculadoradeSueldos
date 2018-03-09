package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;

public class Math extends AppCompatActivity{

    public double tssDeduction = 0;
    public double lawDeduction = 0;
    public double realSalary = 0;

    public double moneyAfterExpenses = 0;

    public double savingsLimit = 0;
    public double debtsLimit = 0;
    public double expensesLimit = 0;
//    public double variableExpensesLimit = 0;

    public Math(int salary, int fixedExpenses, int variableExpenses) {

        tssDeduction = tssDeductionCalculator(salary);
        lawDeduction = lawDeductionCalculator(salary);
        realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);

        savingsLimit = savingsLimitCalculator(realSalary);
        debtsLimit = debtsLimitCalculator(moneyAfterExpenses);
        expensesLimit = expensesLimitCalculator(realSalary);
//        variableExpensesLimit = variableExpensesLimitCalculator(expensesLimit, fixedExpenses);
    }

    public double tssDeductionCalculator(double monthlyMoney) {
        float mTssDedutionPorcent = 0.0592f;
        return (monthlyMoney * mTssDedutionPorcent);
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

    private double savingsLimitCalculator(double realSalary) {
        return realSalary * 0.1;
    }
    private double debtsLimitCalculator(double realSalary) {
        return realSalary * 0.3;
    }
    private double expensesLimitCalculator(double realSalary) {
        return realSalary * 0.6;
    }
//    private double variableExpensesLimitCalculator(double fixedExpensesLimit, int fixedExpenses) {
//        if (fixedExpensesLimit - fixedExpenses > 0){
//
//            return (realSalary * 0.6) - fixedExpenses;
//        }else return 0;
//    }
}
