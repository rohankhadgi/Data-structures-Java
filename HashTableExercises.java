package com.HackerRank;

import javax.swing.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class HashTableExercises {
    private Hashtable<Integer, Integer> number = new Hashtable<>();
    private int[] numbers;
    public HashTableExercises(int[] numbers) {
        this.numbers = numbers;
    }
    public int mostFrequent() {
        int maxCount = 1;
        int returnValue = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(number.containsKey(numbers[i])) {
                int newValue = number.get(numbers[i]) + 1;
                number.put(numbers[i],newValue);
                if (newValue > maxCount) {
                    maxCount = newValue;
                    returnValue = numbers[i];
                }

            }
            else {
                number.put(numbers[i], 1);
            }
        }
        return returnValue;
    }

    public int countPairsWithDiff(int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++)
            set.add(numbers[i]);
        for (var value : numbers) {
            if(set.contains(value + k))
                count++;
            if(set.contains(value - k))
                count++;
            set.remove(value);
        }
        return count;
    }

    public int[] twoSum(int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (number.containsKey(complement))
                return new int[] {complement, numbers[i]};
            else
                number.put(numbers[i],i);
        }
        return null;
    }
}

