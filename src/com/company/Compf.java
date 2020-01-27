package com.company;

import java.util.Scanner;

public class Compf extends Stack{
    // Типы символов (скобки, знаки операции, иное).
    Scanner scan = new Scanner(System.in);
    static int num = 0;
    protected final static int SYM_LEFT = 0,
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;

    private int symType(char c) {
        switch (c) {
            case '(':
                num = 0;
            return SYM_LEFT;
            case ')':
                num = 0;
            return SYM_RIGHT;
            case '+': case '-': case '*': case '/': case '^':
                num = 0;
            return SYM_OPER;
            default:
                num++;
                return symOther(c);
        }
    }
    private void processSymbol(char c) {
        switch (symType(c)) {
            case SYM_LEFT:
                push(c); break;
            case SYM_RIGHT:
                processSuspendedSymbols(c); pop(); break;
            case SYM_OPER:
                processSuspendedSymbols(c); push(c); break;
            case SYM_OTHER:
                nextOther(c); break;
        }
    }
    private void processSuspendedSymbols(char c) {
        while (precedes(top(), c))
            nextOper(pop());
    }
    private int priority(char c) {
        int res = 0;
        if (c == '+' || c == '-')res = 1;
        else if (c == '*' || c == '/')res = 2;
        else if (c == '^')res = 3;
        //return c == '+' || c == '-' ? 1 : 2;
        return res;
    }
    private boolean precedes(char a, char b) {
        if(symType(a) == SYM_LEFT) return false;
        if(symType(b) == SYM_RIGHT) return true;
        return priority(a) >= priority(b);
    }
    protected int symOther(char c) {
        if (c < 'a' || c > 'z') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        System.out.print("" + c + " ");
    }
    protected void nextOther(char c) {
        nextOper(c);
    }
    public void compile(char[] str) {
        processSymbol('(');
        for(int i = 0; i < str.length; i++)
            processSymbol(str[i]);
        processSymbol(')');
        System.out.print("\n");
    }
}
