package com.bluelab.utils;

import com.bluelab.converters.temperature.FahrenheitCelsiusConverter;
import com.bluelab.converters.temperature.KelvinCelsiusConverter;
import com.bluelab.converters.volume.GallonLitreConverter;
import com.bluelab.converters.volume.MillilitreLitreConverter;
import com.bluelab.exceptions.UnsupportedConversionException;
import com.bluelab.unitenum.ConversionEnum;
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

    public static float conversion(ConversionEnum ce, float value) throws Exception {
        float mediateRes;
        switch (ce) {
            case CELSIUS_TO_FAHRENHEIT:
                return new FahrenheitCelsiusConverter().convertFromMid(value);
            case CELSIUS_TO_KELVIN:
                return new KelvinCelsiusConverter().convertFromMid(value);
            case FAHRENHEIT_TO_CELSIUS:
                return new FahrenheitCelsiusConverter().convertToMid(value);
            case FAHRENHEIT_TO_KELVIN:
                mediateRes = new FahrenheitCelsiusConverter().convertToMid(value);
                return new KelvinCelsiusConverter().convertFromMid(mediateRes);
            case KELVIN_TO_CELSIUS:
                return new KelvinCelsiusConverter().convertToMid(value);
            case KELVIN_TO_FAHRENHEIT:
                mediateRes = new KelvinCelsiusConverter().convertToMid(value);
                return new FahrenheitCelsiusConverter().convertFromMid(mediateRes);
            case GALLON_TO_LITRE:
                return new GallonLitreConverter().convertToMid(value);
            case GALLON_TO_MILLILITRE:
                mediateRes = new GallonLitreConverter().convertToMid(value);
                return new MillilitreLitreConverter().convertFromMid(mediateRes);
            case LITRE_TO_GALLON:
                return new GallonLitreConverter().convertFromMid(value);
            case LITRE_TO_MILLILITRE:
                return new MillilitreLitreConverter().convertFromMid(value);
            case MILLILITRE_TO_GALLON:
                mediateRes = new MillilitreLitreConverter().convertToMid(value);
                return new GallonLitreConverter().convertFromMid(mediateRes);
            case MILLILITRE_TO_LITRE:
                return new MillilitreLitreConverter().convertToMid(value);
            default:
                throw new UnsupportedConversionException("Unsupported conversion " + ce);

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

    public static String getSupportedUnitType() {
        return unitMap.keySet().toString();
    }
}
