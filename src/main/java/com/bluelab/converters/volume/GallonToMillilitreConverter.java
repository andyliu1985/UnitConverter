package com.bluelab.converters.volume;

import com.bluelab.converters.Converter;

public class GallonToMillilitreConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value * 3785.412f;
        return String.format("%.2f", result);
    }
}
