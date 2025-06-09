package com.esdc.composite.util;

public final class RegexConst {
    public static final String PARAGRAPH  = "(\\r?\\n){2,}";
    public static final String SENTENCE   = "(?<=[.!?…])\\s+";
    public static final String LEXEME     = "\\s+";                          /
    public static final String ARITHMETIC = "[\\d+\\-*/().]+";
    private RegexConst() {}
}