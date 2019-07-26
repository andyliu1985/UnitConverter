package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class GallonToLitreConverter implements Converter {
    @Override
    public String convert(float value) {
        float result = value * 3.785f;
        return String.format("%.2f", result);
    }
}
