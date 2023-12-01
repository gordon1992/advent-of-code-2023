package com.gordonreid.adventofcode2023.helpers;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@UtilityClass
public final class FileHelpers {

    private static File getFileFromResource(String filename) throws URISyntaxException {
        ClassLoader classLoader = FileHelpers.class.getClassLoader();
        URL resource = classLoader.getResource(filename);
        Objects.requireNonNull(resource, "Could not find " + filename);
        return new File(resource.toURI());
    }

    public static List<String> getResourceLines(String filename) throws URISyntaxException, IOException {
        File file = getFileFromResource(filename);
        return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
    }
}
