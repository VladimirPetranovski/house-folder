package com.by.petranovski.patterns.iterator_suleimanov;

public class JavaDEveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Java", "Spring", "Maven"};
        JavaDeveloper javaDeveloper = new JavaDeveloper("Vavan", skills);
        Iterator iterator = javaDeveloper.getIterator();
        System.out.println("Developer " + javaDeveloper);
        System.out.println("Skills:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
