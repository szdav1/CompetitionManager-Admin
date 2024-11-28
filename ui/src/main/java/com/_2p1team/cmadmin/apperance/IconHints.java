package com._2p1team.cmadmin.apperance;

public record IconHints(String path, int width, int height) {
  public IconHints(final String path, final int size) {
    this(path, size, size);
  }

  public IconHints(final String path) {
    this(path, -1);
  }
}