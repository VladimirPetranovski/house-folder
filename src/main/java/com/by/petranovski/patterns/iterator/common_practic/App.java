package com.by.petranovski.patterns.iterator.common_practic;

import com.by.petranovski.patterns.iterator.common_practic.bean.VovaRestaurant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static final Logger log = LoggerFactory.getLogger("");

    public static void main(String[] args) {
        VovaRestaurant.printCommonMenu();
    }
}
