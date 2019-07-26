package com.bluelab.utils;

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
