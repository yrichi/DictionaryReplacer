package com.kata.dictionaryreplacer;

import java.util.Map;

public class DictionaryReplacer {
    public String replace(String input, Map<String, String> dictionary) {

        if(dictionary == null || dictionary.isEmpty()){
            return input;
        }

        return dictionary.keySet().stream()
                .reduce(input,
                        (acc, key) -> acc.replace(getFormattedKey(key), dictionary.get(key)),
                        (acc, key) -> acc);
    }

    private static String getFormattedKey(String key) {
        return "$" + key + "$";
    }
}
