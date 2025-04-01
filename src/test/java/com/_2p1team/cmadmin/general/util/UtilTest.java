package com._2p1team.cmadmin.general.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.ImageIcon;

class UtilTest {

    @Test
    @DisplayName("Test the raw image loading capability (does not alter the image)")
    void testRawImageIconLoading() {
        ImageIcon icon = Util.loadImageIcon("/assets/testImage.png");

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(icon);
            Assertions.assertEquals(512, icon.getIconWidth());
            Assertions.assertEquals(512, icon.getIconHeight());
        });
    }

    @ParameterizedTest
    @ValueSource(ints={75, 50, 25})
    @DisplayName("Test whether the size of the image is altered (%) correctly relative to the original size")
    void testWhetherTheSizeOfTheImageIsAlteredCorrectly(int percentage) {
        ImageIcon icon = Util.loadImageIcon("/assets/testImage.png", percentage);
        int changedWidth = 512*percentage/100;
        int changedHeight = 512*percentage/100;

        Assertions.assertAll(() -> {
            Assertions.assertEquals(changedWidth, icon.getIconWidth());
            Assertions.assertEquals(changedHeight, icon.getIconHeight());
        });
    }

}