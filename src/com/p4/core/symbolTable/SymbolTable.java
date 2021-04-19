package com.p4.core.symbolTable;


import java.util.ArrayList;
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

    public Scope getCurrentScope() {
        return currentScope;
    }

    //Add a scope to the symbol table
    public void addScope(String scopeName) {
        //Enters, if the scope has not already been entered
        if (lookupScope(scopeName) == null) {
            Scope scope = new Scope(scopeName);
            scope.setParentScope(currentScope);
            currentScope.addScopeChild(scope);
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }

    public void leaveScope() {
        this.leaveScope(null);
    }

    public void leaveScope(String scopeName) {
        //Enters if we're in a non-global scope
        if (currentScope.getParentScope() != null){
            if (scopeName != null){
                currentScope.setScopeName(scopeName);
            }

            //Sets the current scope to the outer scope and removes the scope from the stack
            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
        }
    }

    public void enterScope(String scopeName) {
        Scope scope = this.findScope(scopeName, globalScope);

        if (scope != null){
            scopeStack.push(currentScope):
            currentScope = scope;
        }
    }

    private Scope findScope(String scopeName, Scope currentScope) {
        //Check if the scope we are looking for, is the current scope
        if (currentScope.getScopeName().equals(scopeName)){
            return currentScope;
        }

        Scope scope = null;

        //Iterates through all the nested scopes
        for (Scope childScope : currentScope.getScopeChildren()) {
            scope = this.findScope(scopeName, childScope);

            //Enter if the scope we're looking for is found
            if (scope != null){
                break;
            }
        }

        //If none was found, returns null
        return scope;
    }

    public Scope lookupScope(String scopeName) {
        return this.findScope(scopeName, globalScope);
    }

    public SymbolAttribute lookupSymbol(String symbol){
        Scope scope = currentScope;

        do {
            //Is entered, if the symbol is a parameter
            if (!scope.getParams().isEmpty() && scope.getParams().containsKey(symbol)) {
                return scope.getParams().get(symbol);
            }

            //Is entered if the symbol is a regular symbol AND is found in the current scope
            if (!scope.getSymbols().isEmpty() && scope.getSymbols().containsKey(symbol)) {
                return scope.getSymbols().get(symbol);
            }
        } while((scope = scope.getParentScope()) != null);

        return null;
    }

    public void insertSymbol(String symbol, SymbolAttribute attribute) {
        currentScope.getSymbols().put(symbol, attribute);
    }

    public void insertParam(String paramId, SymbolAttribute attribute) {
        currentScope.getParams().put(paramId, attribute);
    }

    public boolean isFunctionsAndLoopDefined() {
        return (declaredFunctions.contains("function") && declaredFunctions.contains("loop"));
    }
}
