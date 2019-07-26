package com.bluelab.converters.temperature;

import com.bluelab.converters.Converter;

public class KelvinToFahrenheitConverter implements Converter {

    @Override
    public String convert(float value) {
        float result = (value -273.15f) * 9 / 5 + 32;
        return String.format("%.2f", result);
    }
}
