package com.p4.core.symbolTable;

public class SymbolAttributes {
    private int arrayLength;
    private String type;        // func, dcl, param, array
    private String dataType;    // int, double, bool, pos
    private String scope;       // used in for, if/else and func dcl, pos?


    // Used for dcls
    public SymbolAttributes(String nodeType, String dataType) {
        this.type = nodeType;
        this.dataType = dataType;
    }

    // Used for array dcl
    public SymbolAttributes(String nodeType, String dataType, int arrayLength) {
        this.type = nodeType;
        this.dataType = dataType;
        this.arrayLength = arrayLength;
    }


    public String getScope() {
        return this.scope;
    }

    public void setScope() {
        this.scope = scope;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    public int getArrayLength() {
        return this.arrayLength;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
