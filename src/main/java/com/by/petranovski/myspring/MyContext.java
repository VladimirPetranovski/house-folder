package com.by.petranovski.myspring;

import com.by.petranovski.myspring.bean.Humanable;
import com.by.petranovski.myspring.bean.Vavan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MyContext {

    private MyContext() {

    }

    public static Map<String, Object> instances = new ConcurrentHashMap<>();

    static {
        try(Stream<Path> paths = Files.walk(Paths.get("./target"))) {
            List<String> result = paths
                    .filter(a -> a.getFileName().toString().contains("./class"))
                    .map(a -> a.toString())
                    .map(a -> a.substring(a.indexOf("classes/") + "classes/".length(), a.indexOf(".class")))
                    .map(a -> a.replaceAll("/", "."))
                    .collect(Collectors.toList());

            System.out.println("Context loading ...");

            for (String className : result) {
                try {
                    Class<?> clazz = Class.forName(className);
                    instances.put(className.substring(className.lastIndexOf(".") + 1), clazz.newInstance());
                    System.out.println("\tCreate instance of: " + clazz);
                } catch (Exception e) {
                    e.printStackTrace();//no such exception, just go on
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Humanable getHuman(String humanType) {
        if (instances.get(humanType) != null && instances.get(humanType) instanceof Humanable) {
            return (Humanable) instances.get(humanType);
        } else {
            return null;
        }
    }
}
