package com.kata.dictionaryreplacer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DictionaryReplacerTests {


    @Test
    void should_replace_one_word_when_dictionary_has_one_entry() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $name$";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John");
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary);
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello John");
    }

}
