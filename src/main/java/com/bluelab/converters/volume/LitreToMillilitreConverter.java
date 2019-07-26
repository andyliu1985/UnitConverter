package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class LitreToMillilitreConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value * 1000f;
        return String.format("%.2f", result);
    }
}
