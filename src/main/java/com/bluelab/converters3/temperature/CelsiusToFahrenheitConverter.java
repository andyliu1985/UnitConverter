package com.bluelab.converters3.temperature;

import com.bluelab.converters3.Converter;

public class CelsiusToFahrenheitConverter extends Converter {

    private float result = 0;

    public CelsiusToFahrenheitConverter() {}

    public CelsiusToFahrenheitConverter(KelvinToCelsiusConverter fcc, float value) {
        String result = fcc.convert(value);
        this.result = Float.valueOf(result);
    }

    @Override
    public String convert(float value) {
        float result = (value * 9 / 5) + 32;
        return String.format("%.2f", result);
    }

    @Override
    public float getResult() {
        return result;
    }
}
