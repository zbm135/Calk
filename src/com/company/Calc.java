package com.company;

public class Calc extends Compf{
    private StackInt s;
    public int hex = 0;
    private static int char2int(char c) {
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '^':
                int sq=first;
                if(second > 0){
                    for (int i = 1; i < second; i++)
                    {
                        sq*=first;
                    }
                }
                else if(second == 0){
                    sq = 1;
                }
                s.push(sq);
                break;
            case '+':
                        s.push(first + second); break;
            case '-':
                        s.push(first - second); break;
            case '*':
                        s.push(first * second); break;
            case '/':
                        s.push(first / second); break;
//            default:
//                s.push(10*first + second);
//                break;
        }
    }
    protected void nextOther(char c) {
        if(num > 1){
            int a = s.top();
            s.pop();
            s.push(10*a +char2int(c));
        }
        else s.push(char2int(c));
    }
    public Calc() {
        s = new StackInt();
    }
    public final void compile(char[] str) {
        super.compile(str);
        hex = (int)s.top();
        System.out.println("" + s.top());
    }
}
