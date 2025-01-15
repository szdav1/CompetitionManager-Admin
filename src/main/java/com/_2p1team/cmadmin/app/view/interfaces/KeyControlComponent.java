package com._2p1team.cmadmin.app.view.interfaces;

import javax.swing.JComponent;
import java.util.List;

@FunctionalInterface
public interface KeyControlComponent {
    List<JComponent> getKeyControls();
}