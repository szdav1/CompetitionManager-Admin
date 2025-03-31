package com._2p1team.cmadmin.general.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

class LanguageReaderTest {

    static LanguageReader languageReader;
    static Map<String, String> languageMap;

    @BeforeAll
    static void initLanguageReader() {
        languageReader = new LanguageReader();
        languageMap = languageReader.read("/settings/EnglishTest.json");
    }

    @Test
    @DisplayName("Basic test for the LanguageReader, test whether if it reads or not")
    void testBasicTestForTheReader() {
        Assertions.assertNotEquals(0, languageMap.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ComplexTest1"})
    @DisplayName("Complex test for the LanguageReader, reading, fetching and converting to numbers")
    void testComplexReadingTest(final String languageKey) {
        Assertions.assertEquals(255, Integer.parseInt(languageMap.get(languageKey)));
    }

}