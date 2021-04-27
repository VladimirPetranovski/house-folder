package com.by.petranovski.patterns.builder.bean.e;

public class Tuzic extends DogBuilder{
    @Override
    public void buildName() {
       dog.setName("tuzic");
    }

    @Override
    public void buildVoice() {
        dog.setVoice(Voice.RRRR);
    }

    @Override
    public void buildAge() {
        dog.setAge(5);
    }
}
