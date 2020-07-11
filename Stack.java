package com.HackerRank;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Stack<I extends Number> {
    private int count = 0;
    private int[] array = new int[count+1];

    public void push (int input) {
        if (count < array.length) {
            array[count] = input;
        }
        else {
            int[] bigArray = new int[array.length+1];
            for (int i = 0; i < array.length; i++) {
                bigArray[i] = array[i];
            }
            bigArray[count] = input;
            array = bigArray;
        }
        count++;
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        int[] smallArray = new int[array.length-1];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = array[i];
        }
        int popValue = array[array.length-1];
        array = smallArray;
        count--;
        return popValue;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return array[array.length-1];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public boolean isEmpty() {
        return (count == 0);
    }
}
