package com.by.petranovski.patterns.builder.bean.e;

public abstract class DogBuilder {

    public Dog dog;

    public void createDog() {
        dog = new Dog();
    }

    public abstract void buildName();
    public abstract void buildVoice();
    public abstract void buildAge();

    public Dog getDog() {
        return dog;
    }

}
