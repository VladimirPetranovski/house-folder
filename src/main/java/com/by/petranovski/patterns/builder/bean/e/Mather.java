package com.by.petranovski.patterns.builder.bean.e;

public class Mather {

    public DogBuilder dogBuilder;

    public void setDogBuilder(DogBuilder dogBuilder) {
        this.dogBuilder = dogBuilder;
    }

    public Dog buildDog() {
        dogBuilder.createDog();
        dogBuilder.buildName();
        dogBuilder.buildVoice();
        dogBuilder.buildAge();

        Dog dog = dogBuilder.getDog();
        return dog;
    }
}
