package com.HackerRank;

import java.util.HashMap;
import java.util.Map;


public class Hash {
    public char firstNonRepeatingCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();
        var array = input.toCharArray();

        for(var ch: array) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count+1);
        }

        for (var ch: array)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }
}

