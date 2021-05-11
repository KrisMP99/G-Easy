package com.p4.core;

public class CuttingHead {
    private double xCord;
    private double yCord;
    private String unit;
    private String cutMode;
    private String feedRateMode;

    public CuttingHead(double xCord, double yCord, String unit, String cutMode, String feedRateMode){
        this.xCord = xCord;
        this.yCord = yCord;
        this.unit = unit;
        this.cutMode = cutMode;
        this.feedRateMode = feedRateMode;
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

    public boolean setUnit(String unit){
        switch(unit){
            case "metric":
                this.unit = "G21";
                return true;
            case "imperial":
                this.unit = "G20";
                return true;
            default:
                return false;
        }
    }

    public String getUnit(){
        return this.unit;
    }

    public boolean setCutMode(String cutMode){
        switch(cutMode){
            case "absolute":
                this.cutMode = "G90";
                return true;
            case "incremental":
                this.cutMode = "G91";
                return true;
            default:
                return false;
        }
    }

    public String getCutMode(){
        return this.cutMode;
    }

    public boolean setFeedRateMode(String feedRateMode){
        switch(feedRateMode){
            case "inverse":
                this.feedRateMode = "G94";
                return true;
            case "units_per_minute":
                this.feedRateMode = "G93";
                return true;
            default:
                return false;
        }
    }

    public String getFeedRateMode(){
        return this.feedRateMode;
    }

    public void updateHeadPosition(double xCord, double yCord){
        setXCord(xCord);
        setYCord(yCord);
    }

    public String returnGEasyEquivalent(String s){
        switch (s){
            case "G20":
                return "imperial";
            case "G21":
                return "metric";
            case "G90":
                return "absolute";
            case "G91":
                return "incremental";
            case "G93":
                return "units_per_minute";
            case "G94":
                return "inverse";
            default:
                return "Has not been set";
        }
    }
}
