package com.bluelab.converters3.temperature;

import com.bluelab.converters3.Converter;

public class KelvinToFahrenheitConverter extends Converter {

    @Override
    public String convert(float value) {
        float result = (value -273.15f) * 9 / 5 + 32;
        return String.format("%.2f", result);
    }
}
