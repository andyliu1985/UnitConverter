package com.bluelab;

import com.bluelab.exceptions.IncompatibleUnitTypeException;
import com.bluelab.exceptions.UnsupportedUnitTypeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitConverterTest {

    UnitConverter unitConverter = new UnitConverter();

    @Test
    public void testConvert_temperature() throws Exception {
        float result = unitConverter.convert(1, "Celsius", "Kelvin");
        String resultStr = String.format("%.2f", result);
        assertEquals("274.15", resultStr);
    }

    @Test
    public void testConvert_volume() throws Exception {
        float result = unitConverter.convert(1, "litre", "gallon");
        String resultStr = String.format("%.2f", result);
        assertEquals("0.26", resultStr);
    }

    @Test
    public void testConvert_volume_ktF() throws Exception {
        float result = unitConverter.convert(100, "FAHRENHEIT", "KELVIN");
        String resultStr = String.format("%.2f", result);
        assertEquals("310.93", resultStr);
    }

    @Test
    public void testConvert_volume_MltG() throws Exception {
        float result = unitConverter.convert(1, "gallon", "millilitre");
        String resultStr = String.format("%.2f", result);
        assertEquals("3785.41", resultStr);
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void testConvert_throwIncompatibleUnitTypeException() throws Exception {
        unitConverter.convert(1, "Celsius", "Litre");
    }

    @Test(expected = UnsupportedUnitTypeException.class)
    public void testConvert_throwUnsupportedUnitTypeException() throws Exception {
        unitConverter.convert(1, "Area", "Litre");
    }
}
