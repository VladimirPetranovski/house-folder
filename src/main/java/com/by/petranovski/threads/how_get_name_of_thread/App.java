package com.by.petranovski.threads.how_get_name_of_thread;

public class App {
    public static void main(String[] strings) {
        Object lock = new Object();
        new HowGetNameOfThread(lock).start();
        new HowGetNameOfThread(lock).start();
    }

}
