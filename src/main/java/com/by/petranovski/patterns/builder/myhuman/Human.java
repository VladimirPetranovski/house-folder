package com.by.petranovski.patterns.builder.myhuman;

public class Human {

    private String name;
    private String age;
    private int id;

    private Human() {

    }

    private Human(HumanBuilder humanBuilder) {
        this.name = humanBuilder.name;
        this.age = humanBuilder.age;
        this.id = humanBuilder.id;
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }

    public static class HumanBuilder {
        private String name;
        private String age;
        private int id;

        public HumanBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder setAge(String age) {
            this.age = age;
            return this;
        }

        public HumanBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }
}
