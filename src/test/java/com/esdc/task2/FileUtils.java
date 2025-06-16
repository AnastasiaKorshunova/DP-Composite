package com.esdc.task2;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    public static String readFile(String fileName) throws IOException {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(fileName)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
