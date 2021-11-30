package com.by.petranovski.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RandomObjectTest {

    @Test
    void testBinary() throws IOException, ClassNotFoundException {

        String fileName = "objects.data";

        RandomObject randomObject1 = new RandomObject();
        RandomObject randomObject2 = new RandomObject();

        System.out.println("write");

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(randomObject1);
            objectOutputStream.writeObject(randomObject2);
        }

        System.out.println("read");

        RandomObject result1;
        RandomObject result2;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            result1 = (RandomObject) objectInputStream.readObject();
            result2 = (RandomObject) objectInputStream.readObject();
        }

        assertArrayEquals(randomObject1.data, result1.data);
        assertArrayEquals(randomObject2.data, result2.data);
    }

    @Test
    void testXML() throws IOException {

        String fileName = "objects.xml";

        RandomObject randomObject1 = new RandomObject();
        RandomObject randomObject2 = new RandomObject();

        System.out.println("write");

        try(XMLEncoder objectOutputStream = new XMLEncoder(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(randomObject1);
            objectOutputStream.writeObject(randomObject2);
        }

        System.out.println("read");

        RandomObject result1;
        RandomObject result2;

        try(XMLDecoder objectInputStream = new XMLDecoder(new FileInputStream(fileName))) {
            result1 = (RandomObject) objectInputStream.readObject();
            result2 = (RandomObject) objectInputStream.readObject();
        }

        assertArrayEquals(randomObject1.data, result1.data);
        assertArrayEquals(randomObject2.data, result2.data);
    }

    @Test
    void testJSON() throws IOException {

        String fileName = "objects.json";

        RandomObject randomObject1 = new RandomObject();
        RandomObject randomObject2 = new RandomObject();

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("write");

        try(OutputStream objectOutputStream = new FileOutputStream(fileName)) {
            objectMapper.writeValue(objectOutputStream, Arrays.asList(randomObject1, randomObject2));
        }

        System.out.println("read");
        List<RandomObject> randomObjects;

        try(InputStream objectInputStream = new FileInputStream(fileName)) {
            randomObjects = objectMapper.readerForListOf(RandomObject.class).readValue(objectInputStream);
        }

        assertArrayEquals(randomObject1.data, randomObjects.get(0).data);
        assertArrayEquals(randomObject2.data, randomObjects.get(1).data);
    }

}
