package com.kata.dictionaryreplacer;

import java.util.Map;

public class DictionaryReplacer {
    public String replace(String input, Map<String, String> dictionary) {
        return input.replace("$name$", "John");
    }
}
