package com.bluelab.unitenum;

public enum TemperatureEnum implements Unit {
    CELSIUS("°C"),
    FAHRENHEIT("°F"),
    KELVIN("K");

    private String symbol;

    TemperatureEnum(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

}
