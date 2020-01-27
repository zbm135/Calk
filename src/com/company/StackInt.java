package com.company;

public class StackInt {
    private static final int DEFSIZE = 16;
    private int[] array;
    private int head;
    public StackInt() {
        array = new int[DEFSIZE];
        head = 0;
    }
    protected boolean symOther1(int c) {
        if (c < 0 || c > 4000) {
            System.out.println("Недопустимое число: " + c);
            System.exit(0);
        }
        return true;
    }
    public final void push(int val) {array[head++] = val; }
    public final int pop() {
       // this.symOther1(array[0]);
        return array[--head];

    }
    public final int top() { return array[head-1]; }
}
