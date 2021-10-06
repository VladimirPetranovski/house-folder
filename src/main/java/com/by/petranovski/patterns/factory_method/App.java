package com.by.petranovski.patterns.factory_method;

public class App {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createFactory("PHP");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }
    private static DeveloperFactory createFactory(String specialization) {
        if (specialization.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialization.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else if (specialization.equalsIgnoreCase("php")) {
            return new PhpDeveloperFactory();
        }
        throw new RuntimeException(specialization + " specialization didn't found out");
    }
}
