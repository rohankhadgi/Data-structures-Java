package com.HackerRank;

public class Array {
    private static int[] numbers;
    private static int index = 0;

    public Array(int length) {
        numbers = new int[length];
    }

    public void insert(int item) {
        if (index < numbers.length){
            numbers[index] = item;
            index++;
        }
        else {
            int[] moreNumbers = new int[numbers.length + 1];
            for (int i = 0; i < (numbers.length); i++)
                moreNumbers[i] = numbers[i];
            moreNumbers[index] = item;
            index++;
            numbers = moreNumbers;
        }
    }

    public void insertAt(int item, int index) {
        if (index < numbers.length)
        numbers[index] = item;
        else {
            int[] moreNumbers = new int[numbers.length + 1];
            for (int i = 0; i < (numbers.length); i++)
                moreNumbers[i] = numbers[i];
            moreNumbers[index] = item;
            numbers = moreNumbers;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Index is out-of-range.");

        int[] lessNumbers = new int[numbers.length-1];
        int count = 0;
        for (int i = 0; i < lessNumbers.length; i++) {
            if (i == index) {
                count++;
            }
            lessNumbers[i] = numbers[count];
            count++;
        }
        this.numbers = lessNumbers;
    }

    public void indexOf(int item) {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == item) {
                System.out.println("Index: " + i);
            }
            else if (i == numbers.length-1) {
                throw new IllegalArgumentException("This number is not present in the array!");
            }
        }
    }

    public void max() {
        int maxVal = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxVal)
                maxVal = numbers[i];
        }
        System.out.println("The largest number: " + maxVal);
    }

    public void intersect() {
        int[] tempNumbers = new int[numbers.length];
        int[] commonNumbers = new int[numbers.length];
        for (int i = 0; i < tempNumbers.length; i++){
            tempNumbers[i] = numbers[i];
        }
        int commonIndex = 0;
        int occurrenceCount = 0;
        for (int i = 0; i < tempNumbers.length; i++) {
            for (int j = i+1; j < tempNumbers.length; j++) {
                if (tempNumbers[i] == tempNumbers[j]){
                    occurrenceCount++;
                    if (occurrenceCount > 1)
                        tempNumbers[j] = 0;
                    else {
                        commonNumbers[commonIndex] = tempNumbers[i];
                        commonIndex++;
                    }

                }
            }
            occurrenceCount = 0;
        }
        int[] intersectNumbers = new int[commonIndex+1];
        for (int i = 0; i < intersectNumbers.length; i++) {
            intersectNumbers[i] = commonNumbers[i];
        }
        print(intersectNumbers);
    }

    private void reverse() {
        int[] reverseNumbers = new int[numbers.length];
        int count = 0;
        for (int i = numbers.length-1; i >= 0; i--) {
            reverseNumbers[i] = numbers[count];
            count++;
        }

        print(reverseNumbers);
    }

    public void print() {
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
    }

    private void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
    }
}
