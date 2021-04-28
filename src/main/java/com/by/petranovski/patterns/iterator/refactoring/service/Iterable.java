package com.by.petranovski.patterns.iterator.refactoring.service;

import com.by.petranovski.patterns.iterator.refactoring.bean.Iterator;
import com.by.petranovski.patterns.iterator.refactoring.bean.MenuItem;

public interface Iterable<T extends MenuItem> {

    Iterator<T> getMenuIterator();
}
