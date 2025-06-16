package com.esdc.task2.interpreter;

public enum SymbolPriority {

    FIRST_BRACKET("(", 0),
    LAST_BRACKET(")", 0),
    OR("|", 1),
    XOR("^", 2),
    AND("&", 3),
    SHIFT_LEFT("<", 4),
    SHIFT_RIGHT(">", 4),
    ASSIGN_SHIFT_RIGHT("R", 4),
    NOT("~", 5);

    private final String symbol;
    private final int priority;

    SymbolPriority(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static SymbolPriority findBitOperation(String operationName) {
        SymbolPriority found = FIRST_BRACKET;
        for (SymbolPriority operation : values()) {
            if (operation.symbol.equals(operationName)) {
                found = operation;
            }
        }
        return found;
    }

    int getPriority() {
        return priority;
    }
}


