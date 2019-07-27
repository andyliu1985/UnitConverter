package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class KelvinCelsiusConverter implements Converter {

    @Override
    public float convertFromMid(float value) {
        float result = value + 273.15f;
        return result;
    }

    @Override
    public float convertToMid(float value) {
        float result = value - 273.15f;
        return result;
    }

}
