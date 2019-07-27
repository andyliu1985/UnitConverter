package com.bluelab.utils;

import com.bluelab.converters.temperature.FahrenheitCelsiusConverter;
import com.bluelab.converters.temperature.KelvinCelsiusConverter;
import com.bluelab.converters.volume.GallonLitreConverter;
import com.bluelab.converters.volume.MillilitreLitreConverter;
import com.bluelab.exceptions.UnsupportedConversionException;
import com.bluelab.unitenum.Unit;
import com.bluelab.unitenum.TemperatureEnum;
import com.bluelab.unitenum.VolumeEnum;

import java.util.HashMap;

public class Utils {
    private static HashMap<String, Unit> unitMap = new HashMap();

    static {
        unitMap.put(TemperatureEnum.CELSIUS.name(), TemperatureEnum.CELSIUS);
        unitMap.put(TemperatureEnum.FAHRENHEIT.name(), TemperatureEnum.FAHRENHEIT);
        unitMap.put(TemperatureEnum.KELVIN.name(), TemperatureEnum.KELVIN);

        unitMap.put(VolumeEnum.LITRE.name(), VolumeEnum.LITRE);
        unitMap.put(VolumeEnum.MILLILITRE.name(), VolumeEnum.MILLILITRE);
        unitMap.put(VolumeEnum.GALLON.name(), VolumeEnum.GALLON);
    }

    public static String conversion(String converterStr, float value) throws Exception {
        float mediateRes;
        String temp;
        switch (converterStr) {
            case "CELSIUS To FAHRENHEIT":
                return new FahrenheitCelsiusConverter().convertFromMid(value);
            case "CELSIUS To KELVIN":
                return new KelvinCelsiusConverter().convertFromMid(value);
            case "FAHRENHEIT To CELSIUS":
                return new FahrenheitCelsiusConverter().convertToMid(value);
            case "FAHRENHEIT To KELVIN":
                temp = new FahrenheitCelsiusConverter().convertToMid(value);
                mediateRes = Float.valueOf(temp);
                return new KelvinCelsiusConverter().convertFromMid(mediateRes);
            case "KELVIN To CELSIUS":
                return new KelvinCelsiusConverter().convertToMid(value);
            case "KELVIN To FAHRENHEIT":
                temp = new KelvinCelsiusConverter().convertToMid(value);
                mediateRes = Float.valueOf(temp);
                return new FahrenheitCelsiusConverter().convertFromMid(mediateRes);
            case "GALLON To LITRE":
                return new GallonLitreConverter().convertToMid(value);
            case "Gallon To Millilitre":
                temp = new GallonLitreConverter().convertToMid(value);
                mediateRes = Float.valueOf(temp);
                return new MillilitreLitreConverter().convertFromMid(mediateRes);
            case "LITRE To GALLON":
                return new GallonLitreConverter().convertFromMid(value);
            case "LITRE To MILLILITRE":
                return new MillilitreLitreConverter().convertFromMid(value);
            case "MILLILITRE To GALLON":
                temp = new MillilitreLitreConverter().convertToMid(value);
                mediateRes = Float.valueOf(temp);
                return new GallonLitreConverter().convertFromMid(mediateRes);
            case "MILLILITRE To LITRE":
                return new MillilitreLitreConverter().convertToMid(value);
            default:
                throw new UnsupportedConversionException("Unsupported conversion " + converterStr);

        }
    }

    public static boolean isSupported(String unitType) {
        if (unitMap.containsKey(unitType)) {
            return true;
        }
        return false;
    }

    public static Unit getEnum(String unitType) {
        return unitMap.get(unitType);
    }
}
