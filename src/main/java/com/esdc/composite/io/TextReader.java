package com.esdc.composite.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Synchronous utility that loads entire file into memory.
 * Suitable for typical <1-2 MB texts used in the assignment.
 */
public final class TextReader {

    private TextReader() {}

    public static String read(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}
