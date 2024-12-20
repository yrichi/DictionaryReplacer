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
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello John");
    }


    @Test
    void should_replace_two_words_when_dictionary_has_two_entries() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $name$ $surname$";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John");
        dictionary.put("surname", "Doe");
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello John Doe");
    }


    @Test
    void should_replace_three_words_when_dictionary_has_three_entries() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $name$ $surname$ your hobbie is $hobbie$";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John");
        dictionary.put("surname", "Doe");
        dictionary.put("hobbie", "Football");
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello John Doe your hobbie is Football");
    }


    @Test
    void should_not_replace_one_word_when_dictionary_has_one_unmatching_entry() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $surname$";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John");
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello $surname$");
    }


    @Test
    void should_not_replace_one_word_when_dictionary_has_empty() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $surname$";
        Map<String, String> dictionary = new HashMap<>();
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello $surname$");
    }


    @Test
    void should_not_replace_one_word_when_dictionary_has_null() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello $surname$";
        Map<String, String> dictionary = null;
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "$", "$");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello $surname$");
    }


    @Test
    void should_replace_one_word_when_dictionary_has_one_entry_with_different_separator() {
        // GIVEN
        DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();
        String input = "Hello <<name>>";
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("name", "John");
        // WHEN
        String result = dictionaryReplacer.replace(input, dictionary, "<<", ">>");
        // THEN
        Assertions.assertThat(result).isEqualTo("Hello John");
    }

}
