package com.p4.core.symbolTable;

import com.p4.core.nodes.AstNode;

import java.util.ArrayList;
import java.util.List;

public class SymbolAttributes {
    private int arrayLength;
    private List<AstNode> children = new ArrayList<>();
    private String type;        // func, dcl, param, array
    private String dataType;    // int, double, bool, pos
    private String scopeName;


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

    public void addArrayChild(AstNode child) {
        children.add(child);
    }

    public AstNode getArrayChild(AstNode child) {
        if(children.contains(child)) {
            return children.get(children.indexOf(child));
        }
        else {
            return null;
        }
    }

    public List<AstNode> getArrayChildren() {
        return children;
    }

    public void setArrayChildren(List<AstNode> arrayChildren) {
        this.children = arrayChildren;
    }
}
