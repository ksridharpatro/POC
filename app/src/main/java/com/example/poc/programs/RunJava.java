package com.example.poc.programs;

public class RunJava {

    public static String s = "jhhjg";

    static {
        System.out.println("Outer static");
    }

    public static void main(String[] args) {
        Inner.s = "";
        System.out.println("Hello" + s);
    }

    static class Inner {
        public static String s = "jhhjg";

        static {
            System.out.println("Inner static");
        }
    }
}

