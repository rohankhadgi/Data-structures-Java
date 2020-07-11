package com.HackerRank;

import java.util.Arrays;

public class ArrayQueue {
    private int front = 0;
    private int rear;
    private int count = 0;
    private int[] array;

    public ArrayQueue(int size) {
        array = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) {
//            int[] newArray = new int[array.length+1];
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//            }
//            newArray[rear] = item;
            throw new IllegalStateException();
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        count++;
    }

    public int dequeue() {
        count--;
        int item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        return item;
    }

    public int peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == (array.length));
    }

    @Override
    public String toString () {
        return Arrays.toString(array);
    }
}
