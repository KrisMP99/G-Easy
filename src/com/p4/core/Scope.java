package com.p4.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scope {
    private String scopeName;
    private Scope parentScope;

    // We use hashmaps to store our symbols and their attributes
    private HashMap<String, String> symbols = new HashMap<>();
    private HashMap<String, String> params = new HashMap<>();

    // Stores nested scopes
    private List<Scope> scopeChildren = new ArrayList<>();


    public Scope(String name) {
        this.scopeName = name;
    }

    public String getScopeName() {
        return this.scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public Scope getParentScope() {
        return this.parentScope;
    }

    public void setParentScope(Scope parentScope) {
        this.parentScope = parentScope;
    }

    public HashMap<String, String> getSymbols() {
        return this.symbols;
    }

    public void setSymbol(String id, String attribute) {
        symbols.put(id, attribute);
    }

    public HashMap<String, String> getParams() {
        return this.params;
    }

    public void addParams(String id, String attribute) {
        params.put(id, attribute);
    }
}
