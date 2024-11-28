package com._2p1team.cmadmin.util;

import java.io.FileReader;
import java.net.URL;

public final class ResourceHandler {
  public static String getPath(final String path) {
    URL fileURL = ResourceHandler.class.getResource(path);

    if (fileURL == null)
      return "";

    try (FileReader fr = new FileReader(fileURL.getFile())) {
      return fileURL.getFile();
    }
    catch (Exception ignored) {
      return "resources"+path;
    }
  }
}