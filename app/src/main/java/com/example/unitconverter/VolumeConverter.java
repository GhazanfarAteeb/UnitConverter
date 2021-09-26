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

public class VolumeConverter {
    public static String[] volumeTypes = {
            "Milliliters",
            "Cubic Centimeters",
            "Liters",
            "Cubic Meters",
            "Teaspoons (US)",
            "Tablespoons (US)",
            "Fluid Ounces (US)",
            "Cups (US)",
            "Pints (US)",
            "Quarts (US)",
            "Gallons (US)",
            "Cubic Inches",
            "Cubic Feet",
            "Cubic Yards",
            "Teaspoons (UK)",
            "Tablespoons (UK)",
            "Fluid Ounces (UK)",
            "Pints (UK)",
            "Quarts (UK)",
            "Gallons (UK)"
    };

    public static String[] volumeTypesFullNames = {
            "Milliliters",
            "Cubic Centimeters",
            "Liters",
            "Cubic Meters",
            "Teaspoons (US)",
            "Tablespoons (US)",
            "Fluid Ounces (US)",
            "Cups (US)",
            "Pints (US)",
            "Quarts (US)",
            "Gallons (US)",
            "Cubic Inches",
            "Cubic Feet",
            "Cubic Yards",
            "Teaspoons (UK)",
            "Tablespoons (UK)",
            "Fluid Ounces (UK)",
            "Pints (UK)",
            "Quarts (UK)",
            "Gallons (UK)"
    };

    private double convertToSiUnit(double value, int key) {
        double val = 0;
        switch(key) {
            case 0:
            case 1:
                val = value / 1000000;
                break;
            case 2:
                val = value / 1000;
                break;
            case 3:
                val = value;
                break;
            case 4:
                val = value / 202884.1;
                break;
            case 5:
                val = value / 67628.05;
                break;
            case 6:
                val = value / 33814.02;
                break;
            case 7:
                val = value / 4226.753;
                break;
            case 8:
                val = value / 2113.376;
                break;
            case 9:
                val = value / 1056.688;
                break;
            case 10:
                val = value / 264.1721;
                break;
            case 11:
                val = value / 61023.74;
                break;
            case 12:
                val = value / 35.31467;
                break;
            case 13:
                val = value / 1.307951;
                break;
            case 14:
                val = value / 168936.4;
                break;
            case 15:
                val = value / 56312.13;
                break;
            case 16:
                val = value / 35195.08;
                break;
            case 17:
                val = value / 1759.754;
                break;
            case 18:
                val = value / 879.877;
                break;
            case 19:
                val = value / 219.9692;
        }

        return val;
    }

    private double convertSIUnitToResult(double SIUnit, int key) {
        double val = 0;
        switch(key) {
            case 0:
            case 1:
                val = SIUnit * 1000000;
                break;
            case 2:
                val = SIUnit * 1000;
                break;
            case 3:
                val = SIUnit;
                break;
            case 4:
                val = SIUnit * 202884.1;
                break;
            case 5:
                val = SIUnit * 67628.05;
                break;
            case 6:
                val = SIUnit * 33814.02;
                break;
            case 7:
                val = SIUnit * 4226.753;
                break;
            case 8:
                val = SIUnit * 2113.376;
                break;
            case 9:
                val = SIUnit * 1056.688;
                break;
            case 10:
                val = SIUnit * 264.1721;
                break;
            case 11:
                val = SIUnit * 61023.74;
                break;
            case 12:
                val = SIUnit * 35.31467;
                break;
            case 13:
                val = SIUnit * 1.307951;
                break;
            case 14:
                val = SIUnit * 168936.4;
                break;
            case 15:
                val = SIUnit * 56312.13;
                break;
            case 16:
                val = SIUnit * 35195.08;
                break;
            case 17:
                val = SIUnit * 1759.754;
                break;
            case 18:
                val = SIUnit * 879.877;
                break;
            case 19:
                val = SIUnit * 219.9692;
        }

        return val;
    }

    public String getFullName(int index) {
        return volumeTypesFullNames[index];
    }

    public String getResult(double value, int convertFrom, int convertTo) {
    double SIUnit = convertToSiUnit(value, convertFrom);
    double result = convertSIUnitToResult(SIUnit, convertTo);

    BigDecimal res = new BigDecimal(Double.toString(result));
    res = res.setScale(12, RoundingMode.HALF_UP);

    return "" + res.doubleValue();
    }
}
