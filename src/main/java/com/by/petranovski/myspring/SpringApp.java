package com.by.petranovski.myspring;

import com.by.petranovski.myspring.bean.Humanable;

public class SpringApp {
    public static void main(String[] args) {

        Humanable human1 = MyContext.getHuman("SuperHero");
        Humanable human2 = MyContext.getHuman("Vavan");
        Humanable human3 = MyContext.getHuman("Vilan");

        human1.speak();
        human2.speak();
        human3.speak();
    }
}
