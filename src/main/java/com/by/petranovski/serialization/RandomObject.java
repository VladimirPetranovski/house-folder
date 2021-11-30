package com.by.petranovski.serialization;

import java.io.*;

public class RandomObject implements Serializable {

    protected double[] data;

    public RandomObject() {
        data = new double[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.random();
            System.out.println(data[i]);
        }
    }

    public double[] getData() { //for XML
        return data;
    }

    public void setData(double[] data) { // for XML
        this.data = data;
    }

//    private void writeObject(ObjectOutputStream out) throws IOException {  // это если мы хотим управлять сериалиализацией и десириализацией, например зашифровать на поле и расшифровать при чтении
//        out.defaultWriteObject();
//    }
//
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//    }

//    @Override
//    public void writeExternal(ObjectOutput objectOutput) throws IOException {  // это при implements Externalizable
//
//    }
//
//    @Override
//    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
//
//    }
}
