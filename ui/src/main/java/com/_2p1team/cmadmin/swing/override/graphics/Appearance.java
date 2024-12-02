package com._2p1team.cmadmin.swing.override.graphics;

import com._2p1team.cmadmin.swing.override.graphics.consts.InteractivityMode;
import com._2p1team.cmadmin.swing.override.graphics.consts.UIState;
import com._2p1team.cmadmin.swing.override.graphics.hints.*;

public record Appearance(
  boolean interactivityEnabled,
  InteractivityMode interactivityMode,
  UIState state,
  BackgroundHint backgroundHint,
  ForegroundStyle foregroundStyle,
  IconSet iconSet,
  FontSet fontSet,
  BorderHint borderHint
) {
}