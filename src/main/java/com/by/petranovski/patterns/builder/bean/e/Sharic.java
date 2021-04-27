package com.by.petranovski.patterns.builder.bean.e;

public class Sharic extends DogBuilder{
    @Override
    public void buildName() {
        dog.setName("sharic");
    }

    @Override
    public void buildVoice() {
        dog.setVoice(Voice.GAVGAV);
    }

    @Override
    public void buildAge() {
        dog.setAge(3);
    }
}
