package com.p4.core.datatypes;

public class Pos {
    public double x;
    public double y;

    public String id1;
    public String id2;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pos(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id1;
    }
}
