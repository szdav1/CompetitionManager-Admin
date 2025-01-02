package com._2p1team.cmadmin.support.util;

import java.io.FileReader;
import java.net.URL;

public final class ResourceManager {
    public static String get(final String filePath) {
        URL fileURL = ResourceManager.class.getResource(filePath);

        if (fileURL == null)
            return "";

        try (FileReader fr = new FileReader(fileURL.getFile())) {
            return fileURL.getFile();
        }
        catch (Exception exc) {
            return "resources"+filePath;
        }
    }
}