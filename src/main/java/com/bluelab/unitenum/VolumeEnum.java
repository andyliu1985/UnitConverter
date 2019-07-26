package com.bluelab.unitenum;

public enum VolumeEnum implements Unit {
    GALLON("gal"),
    LITRE("l"),
    MILLILITRE("ml");

    private String symbol;

    VolumeEnum(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

}
