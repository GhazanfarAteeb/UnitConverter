package com.example.unitconverter;


import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * FIRST ALL OF THE UNITS WILL BE CONVERTED INTO THEIR BASIC SI UNIT AND THEN IT WILL BE
 * CHANGED INTO THE DESIRED VALUE
 *
 * FOR DOING THIS
 *
 * THERE WILL BE A KEY # 1 REQUIRED THAT FROM WHICH UNIT WE HAVE TO CONVERT THE VALUE
 * AND THEN THERE WILL BE A KEY # 2 REQUIRED THAT TO WHICH UNIT WE UNIT HAVE TO CONVERT THE VALUE
 *
 *
 * THE SIGNS WILL BE OPPOSITE IN BOTH FUNCTIONS CONVERT TO SI AND THEN CONVERT TO THE DESIRED TERM
 *
 *
 * SWITCH CASE WILL BE USED TO SELECT THE CONVERSION FROM AND CONVERSION TO
 * THIS CAN BE DONE WITH THE SAME FUNCTION
 *
 *
 * THE SETTERS AND GETTER METHODS WILL BE USED IN THIS PROCESS FOR SETTING AND GETTING THE VALUES
 *
 */

public class Converter {
    private double convertToSiUnit(double value, int key) {
        double val = 0;
        switch (key) {
            case 0:
                    val = value/1000000;
                break;
            case 1:
                    val = value/10000;
                break;
            case 2:
                    val = value/1550.03;
                break;
            case 3:
                    val = value/10.76391;
                break;
            case 4:
                    val = value;
                break;
            case 5:
                    val = value*1000000;
                break;
            case 6:
                    val = value*2589988;
                break;
            case 7:
                    val = value/1.19599;
                break;
            case 8:
                val = value*10000;
                break;
            case 9:
                    val = value * 4046.856;
                break;
        }

        return val;
    }
    private double convertSIUnitToResult(double SIUnit,int key) {
        double val = 0;
        switch (key) {
            case 0:
                val = SIUnit*1000000;
                break;
            case 1:
                val = SIUnit*10000;
                break;
            case 2:
                val = SIUnit*1550.03;
                break;
            case 3:
                val = SIUnit*10.76391;
                break;
            case 4:
                val = SIUnit;
                break;
            case 5:
                val = SIUnit/1000000;
                break;
            case 6:
                val = SIUnit/2589988;
                break;
            case 7:
                val = SIUnit*1.19599;
                break;
            case 8:
                val = SIUnit/10000;
                break;
            case 9:
                val = SIUnit / 4046.856;
                break;
        }

        return val;
    }

    public String getResult(double value, int convertFrom,int convertTo) {
        double SIUnit = convertToSiUnit(value, convertFrom);
        double result = convertSIUnitToResult(SIUnit, convertTo);

        BigDecimal res = new BigDecimal(Double.toString(result));
        res = res.setScale(12, RoundingMode.HALF_UP);

        return "" + res.doubleValue();
    }



}