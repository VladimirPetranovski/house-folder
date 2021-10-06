package com.by.petranovski.threads.volatiles;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    private static boolean stopped = false; //чтобы программа выполнилась надо пременную назвать volatile
    public static void main( String[] args ) throws InterruptedException {
        new Thread( new C() ).start();
        new Thread( new D() ).start();
        TimeUnit.SECONDS.sleep( 5 );
        System.out.println( "Done" );
        stopped = true;
    }
    static class C implements Runnable {
        @Override
        public void run() {
            while( !stopped ) {
            }
            System.out.println( "Out" );
        }
    }

    static class D implements Runnable {
        @Override
        public void run() {
            while( true ) {
                if( stopped ) {
                    break;
                }
            }
            System.out.println( "Out" );
        }
    }
}
