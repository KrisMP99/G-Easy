package com.p4.core.symbolTable;

public class SymbolAttributes {
    private String varType;
    private String type;
    private String scope;
    private int arrayLength;

    // Used for var dcl
    public SymbolAttributes(String type, String varType) {
        this.type = type;
        this.varType = varType;
    }

    // Used for array dcl
    public SymbolAttributes(String type, String varType, int arrayLength) {
        this.type = type;
        this.varType = varType;
        this.arrayLength = arrayLength;
    }

    public String getType() {
        return this.type;
    }

    public String getVarType() {
        return this.varType;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope() {
        this.scope = scope;
    }

    public int getArrayLength() {
        return this.arrayLength;
    }

}
