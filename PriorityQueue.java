package com.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue {
    private int[] numbers;
    private int index = 0;

    public PriorityQueue(int size) {
        numbers = new int[size];
    }

    public void insert(int item) {
        if (index < numbers.length) {
            if (isEmpty())
                numbers[index] = item;
            compare(item, numbers);
        }
        else {
            int[] newArray = new int[numbers.length + 1];
            for (int i = 0; i < numbers.length; i++)
                newArray[i] = numbers[i];
            compare(item, newArray);
            numbers = newArray;
        }
        index++;
    }

    private void compare(int item, int[] numbers) {
        for (int i = index - 1; i >= 0; i--) {
            if (item < numbers[i]) {
                numbers[i + 1] = numbers[i];
                if (i == 0)
                    numbers[i] = item;
            } else {
                numbers[i + 1] = item;
                break;
            }

        }
    }

    public boolean isEmpty() {
        return (index == 0);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
