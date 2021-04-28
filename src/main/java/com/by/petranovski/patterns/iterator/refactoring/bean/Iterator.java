package com.by.petranovski.patterns.iterator.refactoring.bean;

public interface Iterator<T extends MenuItem> {

    boolean hasNext();
    T next();
}
