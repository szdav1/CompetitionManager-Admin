package com._2p1team.cmadmin.swing.override.graphics.consts;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public enum InteractivityMode {
  BACKGROUND(false),
  FOREGROUND(false),
  ICON(false),
  FONT(false),
  BORDER(false);

  private final boolean enabled;
}