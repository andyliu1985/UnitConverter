package com.bluelab;

import com.bluelab.converters.Converter;
import com.bluelab.converters.temperature.*;
import com.bluelab.converters.volume.*;
import com.bluelab.exceptions.IncompatibleUnitTypeException;
import com.bluelab.exceptions.UnsupportedConversionException;
import com.bluelab.exceptions.UnsupportedUnitTypeException;
import com.bluelab.unitenum.Unit;
import com.bluelab.utils.Utils;

public class UnitConverter {

    public static void main(String[] args) throws Exception {
        float input = 1f;
        String inputUnit = "fahrenheit";
        String outputUnit = "celsius";
        String result = new UnitConverter().convert(input, inputUnit, outputUnit);

        String inputSymbol = Utils.getEnum(inputUnit.toUpperCase()).getSymbol();
        String outputSymbol = Utils.getEnum(outputUnit.toUpperCase()).getSymbol();

        System.out.println(input + inputSymbol + " is equal to " +
                result + outputSymbol);
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

            String converterString = inputUnit + " To " + outputUnit;

            Converter converterInstance = createConverter(converterString);

            return converterInstance.convert(value);

        } else {
            throw new UnsupportedUnitTypeException("Unsupported unit type");
        }
    }

    Converter createConverter(String converterStr) throws Exception {
        switch (converterStr) {
            case "CELSIUS To FAHRENHEIT":
                return new CelsiusToFahrenheitConverter();
            case "CELSIUS To KELVIN":
                return new CelsiusToKelvinConverter();
            case "FAHRENHEIT To CELSIUS":
                return new FahrenheitToCelsiusConverter();
            case "FAHRENHEIT To KELVIN": // TODO fh to ce to kel
                return new FahrenheitToKelvinConverter();
            case "KELVIN To CELSIUS":
                return new KelvinToCelsiusConverter();
            case "KELVIN To FAHRENHEIT":
                return new KelvinToFahrenheitConverter();
            case "GALLON To LITRE":
                return new GallonToLitreConverter();
            case "Gallon To Millilitre":
                return new GallonToMillilitreConverter();
            case "LITRE To GALLON":
                return new LitreToGallonConverter();
            case "LITRE To MILLILITRE":
                return new LitreToMillilitreConverter();
            case "MILLILITRE To GALLON":
                return new MillilitreToGallonConverter();
            case "MILLILITRE To LITRE":
                return new MillilitreToLitreConverter();
            default:
                throw new UnsupportedConversionException("Unsupported conversion " + converterStr);

        }
    }
}
