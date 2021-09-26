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

public class AngleConverter {
    public static String[] angleTypes = {
        "Deg",
        "Gra",
        "Rad"
    };

    public static String[] angleTypesFullNames = {
        "Degrees",
        "Gradians",
        "Radians"
    };

    private double convertToSiUnit(double value, int key) {
        double val = 0;
        switch(key) {
            case 0:
                val = value;
                break;
            case 1:
                val = value / 1.111111;
                break;
            case 2:
                val = Math.toDegrees(value);
                break;
        }

        return val;
    }

    private double convertSIUnitToResult(double SIUnit, int key) {
        double val = 0;
        switch(key) {
            case 0:
                val = SIUnit;
                break;
            case 1:
                val = SIUnit * 1.111111;
                break;
            case 2:
                val = Math.toRadians(SIUnit);
                break;
        }

        return val;
    }

    public String getFullName(int index) {
        return angleTypesFullNames[index];
    }

    public String getResult(double value, int convertFrom, int convertTo) {
        double SIUnit = convertToSiUnit(value, convertFrom);
        double result = convertSIUnitToResult(SIUnit, convertTo);

        BigDecimal res = new BigDecimal(Double.toString(result));
        res = res.setScale(12, RoundingMode.HALF_UP);

        return "" + res.doubleValue();
    }
}
