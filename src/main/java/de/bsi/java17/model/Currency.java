package de.bsi.java17.model;

// https://openjdk.java.net/jeps/409
public abstract sealed class Currency permits Euro, Dollar {

    public abstract String printValue(double value);

}
