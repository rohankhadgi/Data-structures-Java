package com.HackerRank;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListQueue {
    int count = 0;
    Node first;
    Node last;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int item) {
            var current = new Node(item);
            if (isEmpty()) {
                first = last = current;
            }

            else {
                last.next = current;
                last = current;
            }
            count++;
        }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        int removedValue = first.value;
        if (first == last) {
            first = last = null;
        }
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        count--;
        return removedValue;

    }
        public int peek() {
            return first.value;
        }

        public int size() {
            return count;
        }

        public boolean isEmpty() {
            return (first == last);
        }

        @Override
        public String toString() {
            ArrayList<Integer> array = new ArrayList<>();
            Node current = first;
            while (current != null) {
                array.add(current.value);
                current = current.next;
            }
            return array.toString();
        }
    }

