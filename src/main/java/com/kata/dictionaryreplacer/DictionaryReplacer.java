package com.kata.dictionaryreplacer;

import java.util.Map;

public class DictionaryReplacer {
    public String replace(String input, Map<String, String> dictionary) {
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            input = input.replace("$" + entry.getKey() + "$", entry.getValue());
        }
        return input;
    }
}
