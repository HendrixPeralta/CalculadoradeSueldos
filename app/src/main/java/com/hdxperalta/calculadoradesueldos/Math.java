package com.hdxperalta.calculadoradesueldos;

import android.util.Log;

/**
 * Created by hdx on 01/03/18.
 */

public class Math {

    public double tssDeduction = 0;
    public double lawDeduction = 0;
    public double realSalary = 0;
//
//    public double save = 0;
//    public double debt = 0;
//    public double expend = 0;
//
//    public float porcentOfSavings;
//    public float porcentOfDebts;
//    public float porcentOfExpenses;

    public Math(int salary) {

        tssDeduction = tssDeductionCalculator(salary);
        Log.v("Math", "tss Deduction = "
                + tssDeduction);
        lawDeduction = lawDeductionCalculator(salary);
        Log.v("Math", "Law Deduction = "
                + lawDeduction);
        realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);
    }

    private double tssDeductionCalculator(double monthlyMoney) {
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

    private double realSalaryCalculator(int monthlyMoney, double deductionByTss, double deductionByLaw){
        return  monthlyMoney - deductionByLaw - deductionByTss;
    }
}
