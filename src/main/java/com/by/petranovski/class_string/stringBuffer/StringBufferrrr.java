package com.by.petranovski.class_string.stringBuffer;

class StringBufferrrr {
    public static void main(String[] args) {
        //создается 4-мя способами
        StringBuffer firstBuffer = new StringBuffer(); // capacity = 16
        StringBuffer secondBuffer = new StringBuffer("habrahabr"); // capacity = str.length() + 16
        StringBuffer thirdBuffer = new StringBuffer(secondBuffer); // параметр - любой класс, что реализует CharSequence
        StringBuffer fourthBuffer = new StringBuffer(50); // передаем capacity
        String domain = ".ru";


        // создадим буфер с помощью String объекта
        StringBuffer buffer = new StringBuffer("habrahabr"); // "habrahabr"
        // вставим домен в конец
        buffer.append(domain); // "habrahabr.ru"
        // удалим домен
        buffer.delete(buffer.length() - domain.length(), buffer.length()); // "habrahabr"
        // вставим домен в конец на этот раз используя insert
        buffer.insert(buffer.length(), domain); // "habrahabr.ru"
    }
}
