package com.bluelab.utils;

import com.bluelab.unitenum.ConversionEnum;
import com.bluelab.unitenum.TemperatureEnum;
import com.bluelab.unitenum.Unit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Test
    public void testConversion() throws Exception{
        float result = Utils.conversion(ConversionEnum.GALLON_TO_MILLILITRE, 1f);
        String resultStr = String.format("%.2f", result);
        assertEquals("3785.41",resultStr);
    }

    @Test
    public void testIsSupported_True() throws Exception{
        boolean result = Utils.isSupported("KELVIN");
        assertEquals(true, result);
    }

    @Test
    public void testIsSupported_False() throws Exception{
        boolean result = Utils.isSupported("AREA");
        assertEquals(false, result);
    }

    @Test
    public void testGetEnum() throws Exception{
        Unit unit = Utils.getEnum("KELVIN");
        boolean result = unit instanceof TemperatureEnum;
        assertEquals(true, result);
    }

    @Test
    public void testGetSupportedUnitType() throws Exception{
        String result = Utils.getSupportedUnitType();
        assertEquals("[FAHRENHEIT, KELVIN, GALLON, CELSIUS, LITRE, MILLILITRE]", result);
    }

}
