package com.by.petranovski.patterns.iterator.before_refactoring;

import com.by.petranovski.patterns.iterator.before_refactoring.bean.VovaRestaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static final Logger log = LoggerFactory.getLogger("");

    public static void main(String[] args) {
        VovaRestaurant.printCommonMenu();
    }
}
