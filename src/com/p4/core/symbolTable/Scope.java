package com.p4.core.symbolTable;

import java.util.*;

public class Scope {
    private String scopeName;
    private Scope parentScope;

    // We use hashmaps to store our symbols and their attributes
    private HashMap<String, SymbolAttributes> symbols = new HashMap<>();
    private Map<String, SymbolAttributes> params = new LinkedHashMap<>();

    // Stores nested scopes
    private final List<Scope> scopeChildren = new ArrayList<>();


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

    public HashMap<String, SymbolAttributes> getSymbols() {
        return this.symbols;
    }

    public void setSymbol(String id, SymbolAttributes attribute) {
        symbols.put(id, attribute);
    }

    public Map<String, SymbolAttributes> getParams() {
        return this.params;
    }

    public void addParams(String id, SymbolAttributes attribute) {
        params.put(id, attribute);
    }

    public List<Scope> getScopeChildren() {
        return scopeChildren;
    }

    public void addScopeChild(Scope scopeChild) {
        scopeChildren.add(scopeChild);
    }
}
