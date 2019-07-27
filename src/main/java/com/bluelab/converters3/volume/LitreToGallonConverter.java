package com.bluelab.converters3.volume;

import com.bluelab.converters3.Converter;

public class LitreToGallonConverter extends Converter {
    @Override
    public String convert(float value) {
        float result = value / 3.785f;
        return String.format("%.2f", result);
    }
}
