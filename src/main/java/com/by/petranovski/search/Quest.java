package com.by.petranovski.search;

public class Quest extends Thread{

    Quest () {}
    Quest (Runnable r) {
        super(r);
    }
    public void run() {
        System.out.print("thread ");
    }
    public static void main(String[] args) {
        Runnable r = new Quest();  //1
        Quest t = new Quest(r);  //2
        t.start();
    }
}
