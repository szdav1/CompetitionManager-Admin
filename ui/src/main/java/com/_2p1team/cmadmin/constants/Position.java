package com._2p1team.cmadmin.constants;

import java.awt.BorderLayout;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Position {
  TOP(4),
  MIDDLE(3),
  LOW(2),
  BACKGROUND(1),

  UP(BorderLayout.NORTH),
  BOTTOM(BorderLayout.SOUTH),
  CENTER(BorderLayout.CENTER),
  LEFT(BorderLayout.WEST),
  RIGHT(BorderLayout.EAST);

  private final int value;
  private final String layoutPosition;

  Position(final int value) {
    this.value = value;
    this.layoutPosition = "";
  }

  Position(final String layoutPosition) {
    this.value = 3;
    this.layoutPosition = layoutPosition;
  }
}
