package com.kata.dictionaryreplacer;

import java.util.Map;

public class DictionaryReplacer {
    public String replace(String input, Map<String, String> dictionary, String openSeparator, String closeSeparator) {

        if(dictionary == null || dictionary.isEmpty()){
            return input;
        }

        return dictionary.keySet().stream()
                .reduce(input,
                        (acc, key) -> acc.replace(getFormattedKey(key,openSeparator,closeSeparator), dictionary.get(key)),
                        (acc, key) -> acc);
    }

    private static String getFormattedKey(String key, String openSeparator, String closeSeparator) {
        return openSeparator + key + closeSeparator;
    }
}
