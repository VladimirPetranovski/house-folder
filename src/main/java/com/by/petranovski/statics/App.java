package com.by.petranovski.statics;

public class App {

    public static class A {
        public void doSmth1() {
            System.out.println("This is doSmth1() in A...");
        }
        public static void doSmth2() {
            System.out.println("This is doSmth2() in A...");
        }
        public void doSmth3(long a) {
            System.out.println("This is doSmth3() in A...");
        }
    }

    public static class B extends A {
        public void doSmth1() {
            System.out.println("This is doSmth1() in B...");
        }

        public static void doSmth2() {
            System.out.println("This is doSmth2() in B...");
        }
        public void doSmth3(int a) {
            System.out.println("This is doSmth3() in B...");
        }
    }

    public static void test(A a) {
        a.doSmth1();
        a.doSmth2();
        a.doSmth3(1);
    }

    public static void main(String[] args) {
        test(new B());
    }

}
