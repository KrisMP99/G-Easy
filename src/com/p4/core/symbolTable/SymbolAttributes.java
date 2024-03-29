package com.p4.core.symbolTable;

import com.p4.core.nodes.AstNode;

import java.util.ArrayList;
import java.util.List;

public class SymbolAttributes {
    private int arrayLength;
    private String type;        // func, dcl, param, array
    private String dataType;    // int, double, bool, pos
    private String scopeName;
    private String value;
    private AstNode node;   // The node itself


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
        return this.scopeName;
    }

    public void setScope(String scope) {
        this.scopeName = scope;
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

    @Override
    public String toString() {
        return "type: " + type + " datatype: " + dataType + " scope: " + scopeName + " arrayLength: " + arrayLength;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AstNode getNode() {
        return node;
    }

    public void setNode(AstNode node) {
        this.node = node;
    }
}
