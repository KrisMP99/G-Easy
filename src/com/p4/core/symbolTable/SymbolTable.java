package com.p4.core.symbolTable;

import com.sun.source.tree.Scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
    private Scope currentScope;
    final private Scope globalScope;
    final private Stack<Scope> scopeStack = new Stack<Scope>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();
    public ArrayList<String> calledFunctions = new ArrayList<>();

    public SymbolTable() {
        globalScope = new Scope("global");
        currentScope = new Scope("local");
    }

    public void addScope() {}

    public void leaveScope() {
        this.leaveScope(null);
    }

    private void leaveScope(String scopeName) {
        if (currentScope.get)
    }


}
