package com.HackerRank;

public class TwoStacks {
    int count = 0;
    int size = 10;
    private int[] array = new int[size];
    int totalCount = 0;
    int index2 = 5;
    int count2 = 0;

    public void push1(int input1) {
        if (isFull1()) {
            size++;
            int[] newArray = new int[size];
            for (int i = 0; i < count; i++)
                newArray[i] = array[i];
            newArray[count] = input1;
            count++;
            totalCount++;
            index2++;
            for (int i = index2; i < newArray.length; i++) {
                int num = 0;
                newArray[i] = array[count+num];
                num++;
            }
            array = newArray;
        }
        else {
            array[count] = input1;
            count++;
            totalCount++;
        }
    }

    public void push2(int input2) {
        if (isFull2()) {
            size++;
            int[] newArray = new int[size];
            for (int i = 0; i < array.length; i++)
                newArray[i] = array[i];
            newArray[array.length] = input2;
            count2++;
            totalCount++;
            array = newArray;
        }
        else {
            array[index2 + count2] = input2;
            count2++;
            totalCount++;
        }
    }

    public int pop1() {
        size--;
        int pop = array[count-1];
        int[] newArray = new int[size];
        for (int i = 0; i < count-1; i++) {
            newArray[i] = array[i];
        }
        count--;
        for (int i = count; i < newArray.length; i++) {
            int num = 0;
            newArray[i] = array[count + num];
            num++;
        }
        //count2--;
        totalCount--;
        array = newArray;
        return pop;
    }

    public int pop2() {
        size--;
        int pop = array[array.length-1];
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        count2--;
        totalCount--;
        array = newArray;
        return pop;
    }

    public boolean isEmpty1() {
        return (count == 0);
    }

    public boolean isEmpty2() {
        return (count2 == 0);
    }

    public boolean isFull1() {
        return (count == index2);
    }

    public boolean isFull2() {
        return (index2+count2==array.length);
    }
}