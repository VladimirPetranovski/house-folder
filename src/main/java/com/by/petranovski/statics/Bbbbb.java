package com.by.petranovski.statics;

public class Bbbbb {
    public static void main(String[] args) {
        Dog.voice(); // Вывод: Гав
    }
}

class Animal {
    public static void voice() {
        System.out.print("звук");
    }
}
class Dog extends Animal {
    // Метод определенный в классе-наследнике идентичный по сигнатуре с методом родительского класса
    public static void voice() {
        System.out.print("Гав");
    }
}
