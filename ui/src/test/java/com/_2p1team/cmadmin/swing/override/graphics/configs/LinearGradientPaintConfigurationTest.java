package com._2p1team.cmadmin.swing.override.graphics.configs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Color;

class LinearGradientPaintConfigurationTest {

    static LinearGradientPaintConfiguration configuration;

    @BeforeAll
    @DisplayName("Before test set up")
    static void setUpConfiguration() {
        configuration = new LinearGradientPaintConfiguration();
    }

    @Test
    @DisplayName("Configured colors should be RED, GREEN and BLUE")
    void testColorsShouldBeRGB() {
        configuration.setColors(Color.red, Color.green, Color.blue);

        Assertions.assertAll(
            () -> Assertions.assertEquals(Color.red, configuration.getColors()[0]),
            () -> Assertions.assertEquals(Color.green, configuration.getColors()[1]),
            () -> Assertions.assertEquals(Color.blue, configuration.getColors()[2])
        );
    }

    @Test
    @DisplayName("Configured fractions should be 0.0f, 0.25f, 0.5f, 1.0f")
    void testFractionsShouldDividedToFourEqualSections() {
        configuration = new LinearGradientPaintConfiguration(Color.red, Color.green, Color.blue, Color.pink);

        Assertions.assertAll(
            () -> Assertions.assertEquals(0.0f, configuration.getFractions()[0]),
            () -> Assertions.assertEquals(0.25f, configuration.getFractions()[1]),
            () -> Assertions.assertEquals(0.5f, configuration.getFractions()[2]),
            () -> Assertions.assertEquals(1.0f, configuration.getFractions()[3])
        );
    }

}