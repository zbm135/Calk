package com.company;

import java.util.Scanner;

public class CalcTest {

    public static void main(String[] args) throws Exception {
        String ans = "";
        Scanner scan = new Scanner(System.in);
        Calc c = new Calc();
        while (true) {
            System.out.println("Введите формулу -> ");
            c.compile(scan.nextLine().toCharArray());
            ans = Integer.toHexString(c.hex);
            System.out.println(ans);
            }
    }
}
