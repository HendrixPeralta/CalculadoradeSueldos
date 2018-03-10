package com.hdxperalta.calculadoradesueldos;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.NumberFormat;

public class Math extends AppCompatActivity{

    private final static float SAVING_PERCENT = 0.1F;
    private final static float EXPENSES_PERCENT = 0.6F;
    private final static float DEBTS_PERCENT = 0.3F;
    private final static float TSS_PERCENT = 0.0592f;

    public double tssDeduction = 0;
    public double lawDeduction = 0;
    public double realSalary = 0;

    public double savingsLimit = 0;
    public double debtsLimit = 0;
    public double expensesLimit = 0;
    public double availableMoney = 0;

    public Math(int salary, int fixedExpenses, int variableExpenses) {

        tssDeduction = percentCalculator(salary, TSS_PERCENT);
        lawDeduction = lawDeductionCalculator(salary);
        realSalary = realSalaryCalculator(salary, tssDeduction, lawDeduction);

        savingsLimit = percentCalculator(realSalary, SAVING_PERCENT);
        debtsLimit = percentCalculator(realSalary, DEBTS_PERCENT);
        expensesLimit = percentCalculator(realSalary, EXPENSES_PERCENT);

        availableMoney = availableMoneyCalculator(expensesLimit, fixedExpenses, variableExpenses);
    }

    private double availableMoneyCalculator(double expensesLimit, int fixedExpenses, int variableExpenses) {
        double result = expensesLimit - fixedExpenses - variableExpenses;
        return (result > 0)?  result :  0;
//        if ( result > 0){
//            return result;
//        }else return 0;
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
    private double percentCalculator(double realSalary, float percent){
        return realSalary * percent;
    }


}
