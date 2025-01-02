package com._2p1team.cmadmin.support.util;

import javax.swing.ImageIcon;
import java.awt.Image;

public final class Util {
    public static ImageIcon loadImageIcon(final String path) {
        return new ImageIcon(ResourceManager.get(path));
    }

    public static ImageIcon loadImageIcon(final String path, int percentage) {
        ImageIcon icon = loadImageIcon(path);
        int width = (int) (icon.getIconWidth()*percentage/100.0f);
        int height = (int) (icon.getIconHeight()*percentage/100.0f);

        return loadImageIcon(path, width, height);
    }

    public static ImageIcon loadImageIcon(final String path, int width, int height) {
        return new ImageIcon(loadImageIcon(path).getImage()
            .getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}