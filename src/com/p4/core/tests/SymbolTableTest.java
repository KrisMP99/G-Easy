package com.p4.core.tests;

import com.p4.core.GEasyLexer;
import com.p4.core.symbolTable.Scope;
import com.p4.core.symbolTable.SymbolTable;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolTableTest {
    public SymbolTable symbolTable;

    @BeforeEach
    void setup() {
        symbolTable = new SymbolTable();
    }

    @Test
    public void getCurrentScope_returnsTheAddedScope() {
        //Arrange
        String scopeName = "scope";
        symbolTable.addScope(scopeName);

        //Act
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(scopeName));
    }

    @Test
    public void getCurrentScope_noScopeAdded_returnsGlobalScope() {
        //Arrange
        String scope = "global";

        //Act
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(scope));
    }

    @Test
    public void addScope_EntersTheGivenScope() {
        //Arrange
        String scope = "newScope";
        symbolTable.addScope(scope);

        //Act
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(scope));
    }

    @Test
    public void addScope_receivesExistingScope_staysInCurrentScope() {
        //Arrange
        String scope = "existingScope";
        String globalScope = "global";
        symbolTable.addScope(scope);
        symbolTable.leaveScope();

        //Act
        symbolTable.addScope(scope);
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(globalScope));
    }

    @Test
    public void leaveScope_leavesTheCurrentScope() {
        //Arrange
        String currentScope = "currentScope";
        String globalScope = "global";
        symbolTable.addScope(currentScope);

        //Act
        symbolTable.leaveScope();
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(globalScope));
    }

    @Test
    public void leaveScope_noScopeToLeave_staysInGlobalScope() {
        //Arrange
        String globalScope = "global";

        //Act
        symbolTable.leaveScope();
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(globalScope));
    }

    @Test
    public void enterScope_entersTheGivenScope() {
        //Arrange
        String scope = "existingScope";
        symbolTable.addScope(scope);
        symbolTable.leaveScope();

        //Act
        symbolTable.enterScope(scope);
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(scope));
    }

    @Test
    public void enterScope_staysInCurrentScope_whenScopeDoesNotExist() {
        //Arrange
        String scope = "nonExistingScope";
        String globalScope = "global";

        //Act
        symbolTable.enterScope(scope);
        String result = symbolTable.getCurrentScope().getScopeName();

        //Assert
        assert (result.equals(globalScope));
    }

    @Test
    public void lookUpScope_returnsTheFoundScope() {
        //Arrange
        String scope = "scope";
        symbolTable.addScope(scope);

        //Act
        String result = symbolTable.lookupScope(scope).getScopeName();

        //Assert
        assert (result.equals(scope));
    }
}
