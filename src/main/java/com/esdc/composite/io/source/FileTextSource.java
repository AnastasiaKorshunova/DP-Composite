package com.esdc.composite.io.source;

import java.nio.file.Path;

public final class FileTextSource implements TextSource {
    private final Path path;
    public FileTextSource(Path path) { this.path = path; }

    @Override public String load() throws Exception {
        return com.esdc.composite.io.TextReader.read(path);
    }
}
