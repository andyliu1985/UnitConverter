package com.bluelab;

import com.bluelab.exceptions.IncompatibleUnitTypeException;
import com.bluelab.exceptions.UnsupportedConversionException;
import com.bluelab.exceptions.UnsupportedUnitTypeException;
import com.bluelab.unitenum.ConversionEnum;
import com.bluelab.unitenum.Unit;
import com.bluelab.utils.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UnitConverter {
    static Logger logger = Logger.getLogger(UnitConverter.class.getName());

    public static void main(String[] args) {

        if (args.length == 3) {
            float input = Float.valueOf(args[0]);
            String inputUnit = args[1];
            String outputUnit = args[2];
            String result = null;
            try {
                result = new UnitConverter().convert(input, inputUnit, outputUnit);
            } catch (IncompatibleUnitTypeException e) {
                logger.log(Level.SEVERE, e.getMessage() + e.getStackTrace());
                throw new RuntimeException(e);
            } catch (UnsupportedConversionException e) {
                logger.log(Level.SEVERE, e.getMessage() + e.getStackTrace());
                throw new RuntimeException(e);
            } catch (UnsupportedUnitTypeException e) {
                logger.log(Level.SEVERE, e.getMessage() + e.getStackTrace());
                throw new RuntimeException(e);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage() + e.getStackTrace());
                throw new RuntimeException(e);
            }

            String inputSymbol = Utils.getEnum(inputUnit.toUpperCase()).getSymbol();
            String outputSymbol = Utils.getEnum(outputUnit.toUpperCase()).getSymbol();

            logger.log(Level.INFO,input + inputSymbol + " is equal to " +
                    result + outputSymbol);
        } else {
            logger.log(Level.SEVERE, "Please input value, input unit and output unit");
            logger.log(Level.SEVERE, "Supported unit type:" + Utils.getSupportedUnitType());
        }

    }

    String convert(float value, String inputUnit, String outputUnit) throws Exception {
        inputUnit = inputUnit.toUpperCase();
        outputUnit = outputUnit.toUpperCase();
        if (Utils.isSupported(inputUnit) && Utils.isSupported(outputUnit)) {
            Unit inputEnum = Utils.getEnum(inputUnit);
            Unit outputEnum = Utils.getEnum(outputUnit);

            if (inputEnum.getClass() != outputEnum.getClass()) {
                throw new IncompatibleUnitTypeException("Can not convert from " + inputUnit + " to " + outputUnit + ", they are not compatible");
            }

            String converterString = inputUnit + "_TO_" + outputUnit;
            ConversionEnum ce = ConversionEnum.valueOf(converterString);
            return Utils.conversion(ce, value);

        } else {
            throw new UnsupportedUnitTypeException("Unsupported unit type");
        }
    }

}
