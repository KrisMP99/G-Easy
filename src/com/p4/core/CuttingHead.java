package com.p4.core;

public class CuttingHead {
    private double xCord;
    private double yCord;

    public CuttingHead(double xCord, double yCord){
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public double getXCord() {
        return xCord;
    }

    public void setXCord(double xCord) {
        this.xCord = xCord;
    }

    public double getYCord() {
        return yCord;
    }

    public void setYCord(double yCord) {
        this.yCord = yCord;
    }

    public void updateHeadPosition(double xCord, double yCord){
        this.xCord = xCord;
        this.yCord = yCord;
    }
}
