package com.HackerRank;

import java.util.Stack;

public class StacksQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();
    private int size;
    private int count;

    public StacksQueue(int size) {
        this.size = size;
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();
        stack.push(item);
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        for (int i = 0; i < count-1; i++) {
            tempStack.push(stack.pop());
        }
        int dequeued = stack.pop();
        count--;
        for (int i = 0; i < count-1; i++) {
            stack.push(tempStack.pop());
        }
        return dequeued;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        for (int i = 0; i < count-2; i++) {
            tempStack.push(stack.pop());
        }
        int peeked = stack.peek();
        for (int i = 0; i < count-1; i++) {
            stack.push(tempStack.pop());
        }
        return peeked;
    }

    public boolean isEmpty() {
        return (stack.isEmpty());
    }

    public boolean isFull() {
        return (count == size);
    }

    @Override
    public String toString () {
        return stack.toString();
    }
}
