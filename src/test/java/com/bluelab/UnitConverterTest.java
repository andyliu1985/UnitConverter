package com.bluelab;

import com.bluelab.exceptions.IncompatibleUnitTypeException;
import com.bluelab.exceptions.UnsupportedUnitTypeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitConverterTest {

    static UnitConverter unitConverter = new UnitConverter();

    @Test
    public void testConvert_temperature() throws Exception {
        String result = unitConverter.convert(1, "Celsius", "Kelvin");
        assertEquals(result, "274.15");
    }

//    public void testConvert_volume() throws Exception {
//        String result = unitConverter.convert(1, "litre", "gallon");
//        assertEquals(result, "0.26");
//    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void testConvert_throwIncompatibleUnitTypeException() throws Exception {
        unitConverter.convert(1, "Celsius", "Litre");
    }

    @Test(expected = UnsupportedUnitTypeException.class)
    public void testConvert_throwUnsupportedUnitTypeException() throws Exception {
        unitConverter.convert(1, "Area", "Litre");
    }
}
