package com._2p1team.cmadmin.general.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.FileReader;
import java.net.URL;

@AllArgsConstructor(access=AccessLevel.NONE)
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