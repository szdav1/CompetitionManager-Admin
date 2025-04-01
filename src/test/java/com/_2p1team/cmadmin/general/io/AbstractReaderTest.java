package com._2p1team.cmadmin.general.io;

import org.junit.jupiter.api.*;

import java.util.Map;

class AbstractReaderTest {

    static final String LANGUAGE_TEST_FILE = "/settings/EnglishTest.json";
    static final String SETTINGS_TEST_FILE = "/settings/SettingsTest.json";

    @Nested
    @DisplayName("LanguageReader tests")
    class LanguageReaderTest {

        static LanguageReader languageReader;
        static Map<String, String> languageMap;

        @BeforeAll
        static void initReader() {
            languageReader = new LanguageReader();
            languageMap = languageReader.read(AbstractReaderTest.LANGUAGE_TEST_FILE);
        }

        @Test
        @DisplayName("Test whether the reader object reads the json file appropriately")
        void basicReaderTest() {
            Assertions.assertFalse(languageMap.isEmpty());
        }

        @Test
        @DisplayName("Test if the reader object read and structure the json file correctly")
        void testTheValuesReadByTheReaderObject() {
            Assertions.assertEquals("This is a basic text for testing the language reader class!", languageMap.get("BasicTestText"));
        }

        @Test
        @DisplayName("Test whether the reader object reads numeric values correctly")
        void testReadValuesConversionFromStringToInt() {
            int intValue = Integer.parseInt(languageMap.get("StringToIntegerTest"));
            float floatValue = Float.parseFloat(languageMap.get("StringToFloatTest"));

            Assertions.assertAll(() -> {
                Assertions.assertEquals(255, intValue);
                Assertions.assertEquals(23.43F, floatValue);
            });
        }

    }

    @Nested
    @DisplayName("SettingsReader tests")
    class SettingsReaderTest {

        static SettingsReader settingsReader;
        static Map<String, String> settingsMap;

        @BeforeAll
        static void initReader() {
            settingsReader = new SettingsReader();
            settingsMap = settingsReader.read(AbstractReaderTest.SETTINGS_TEST_FILE);
        }

        @Test
        @DisplayName("Test if the reader object read and structure the json file correctly")
        void basicReaderTest() {
            Assertions.assertFalse(settingsMap.isEmpty());
        }

        @Test
        @DisplayName("Test if the reader object read and structure the json file correctly")
        void testTheValuesReadByTheReaderObject() {
            Assertions.assertEquals("English.json", settingsMap.get("TestLanguageOption"));
        }

    }

}