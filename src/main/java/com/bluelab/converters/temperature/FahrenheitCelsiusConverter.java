package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class FahrenheitCelsiusConverter implements Converter {

    @Override
    public float convertToMid(float value) {
        float result = ((value - 32) * 5 / 9);
        return result;
    }

    @Override
    public float convertFromMid(float value) {
        float result = (value * 9 / 5) + 32;
        return result;
    }
}
