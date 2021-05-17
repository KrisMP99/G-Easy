package com.p4.core.symbolTable;


import java.util.ArrayList;
import java.util.Stack;

public class SymbolTable {
    private Scope currentScope;
    final private Scope globalScope;
    final private Stack<Scope> scopeStack = new Stack<>();
    public ArrayList<String> declaredFunctions = new ArrayList<>();
    public ArrayList<String> calledFunctions = new ArrayList<>();

    public SymbolTable() {
        globalScope = new Scope("global");
        currentScope = globalScope;
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    // Add a scope to the symbol table
    public void addScope(String scopeName) {
        // When we add a scope we also enter the scope
        if (lookupScope(scopeName) == null) {
            Scope scope = new Scope(scopeName);

            // The parent scope must be the current scope, before we enter the new scope
            scope.setParentScope(currentScope);

            // We add the new scope we're creating to the current scope (the parent scope)
            currentScope.addScopeChild(scope);

            // Push the scope to the scope stack, and enter the new scope
            scopeStack.push(currentScope);
            currentScope = scope;
        }
    }


    // Leave the current scope
    public void leaveScope() {
        // We can only leave the current scope, if there is a parent scope
        // Otherwise, we're already in the global scope
        if (currentScope.getParentScope() != null){

            // Sets the current scope to the outer scope and removes the scope from the stack
            currentScope = scopeStack.empty() ? globalScope : scopeStack.pop();
        }
    }

    // Enters a specific scope
    public void enterScope(String scopeName) {
        Scope scope = this.findScope(scopeName, globalScope);

        if (scope != null){
            scopeStack.push(currentScope);
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

            if(scope != null) {
                break;
            }
        }

        return scope;
    }

    public Scope lookupScope(String scopeName) {
        return this.findScope(scopeName, globalScope);
    }

    public SymbolAttributes lookupSymbol(String symbol){
        do {
            // Look for the symbol in the current scope
            if (!currentScope.getSymbols().isEmpty() && currentScope.getSymbols().containsKey(symbol)) {
                return currentScope.getSymbols().get(symbol);
            }

            // If the symbol is a parameter and in the current scope
            if (!currentScope.getParams().isEmpty() && currentScope.getParams().containsKey(symbol)) {
                return currentScope.getParams().get(symbol);
            }

            // If we could not find the symbol we're looking for, we go to the outer scope and look there.
        } while((currentScope = currentScope.getParentScope()) != null);

        return null;
    }

    public void insertSymbol(String symbol, SymbolAttributes attribute) {
        currentScope.setSymbol(symbol, attribute);
    }

    public void insertParam(String paramId, SymbolAttributes attribute) {
        currentScope.addParams(paramId, attribute);
    }
}
