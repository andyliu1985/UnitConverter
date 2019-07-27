package com.bluelab.converters3.volume;

import com.bluelab.converters3.Converter;

public class MillilitreToLitreConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value / 1000f;
        return String.format("%.2f", result);
    }
}
