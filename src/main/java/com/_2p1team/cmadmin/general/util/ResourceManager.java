package com._2p1team.cmadmin.general.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.FileReader;
import java.net.URL;

@AllArgsConstructor(access=AccessLevel.NONE)
public final class ResourceManager {

    @Setter
    private static String productionResourcePath = "";

    public static String get(final String filePath) {
        URL fileURL = ResourceManager.class.getResource(filePath);

        if (fileURL == null)
            return "";

        // Returns the development resources
        try (FileReader fr = new FileReader(fileURL.getFile())) {
            return fileURL.getFile();
        }
        // Returns the production resources
        catch (Exception exc) {
            return "resources/"+productionResourcePath+filePath;
        }
    }

}