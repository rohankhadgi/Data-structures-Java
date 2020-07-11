package com.HackerRank;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int nodeCount = 0;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addFirst(int e) {
        var node = new Node(e);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        nodeCount++;
    }

    public void addLast(int e) {
        var node = new Node(e);
        if (isEmpty()) {
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }

        nodeCount++;
    }

    public int indexOf(int e) {
        Node searchNode = first;
        for (int i = 0; i < nodeCount; i++) {
            if (searchNode.value == e)
                return i;
            else {
                searchNode = searchNode.next;
            }
        }
        return -1;
    }

    public boolean contains(int e) {
        return (indexOf(e) != -1);
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            nodeCount--;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;

        nodeCount--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            nodeCount--;
            return;
        }
        var previousNode = previous(last);
        last = previousNode;
        last.next = null;
        nodeCount--;
    }

    private Node previous(Node node) {
        var searchNode = first;
        while (searchNode != null) {
            if (searchNode.next == last) return searchNode;
            searchNode = searchNode.next;
        }
        return null;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previousNode = first;
        var searchNode = first.next;
        while (searchNode != null) {
            var nextNode = searchNode.next;
            searchNode.next = previousNode;
            previousNode = searchNode;
            searchNode = nextNode;
        }
        last = first;
        last.next = null;
        first = previousNode;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new NoSuchElementException();
        var node1 = first;
        var node2 = first;
        while (node1 != null) {
            node1 = (node1.next).next;
            node2 = node2.next;

            if (node1.next == null) {
                System.out.println("Middle value: " + node2.value);
                return;
            }
            else if ((node1.next).next == null) {
                System.out.println("Middle values: " + node2.value + ", " + node2.next.value);
                return;
            }
        }
    }

    public void formLoop() {
        int value = 44;
        var searchNode = first;
        var tempNode = last;
        while (searchNode.value != 44) {
            searchNode = searchNode.next;
            if (searchNode.value == 44) {
                searchNode.next = tempNode;
            }
            return;
        }
    }

    public boolean hasLoop() {
        if (isEmpty())
            throw new IllegalStateException();
        boolean hasLoop = false;
        var node1 = first;
        var node2 = first;

        while (node1 != null && node2.next != null) {
                node2 = node2.next;
                node1 = node1.next.next;

            if (node1 == node2)
                hasLoop = true;
        }
        return hasLoop;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var front = first;
        Node nextNode = first;

        int index = 0;

        while (index < k-1) {
            nextNode = nextNode.next;
            if (nextNode == null)
                throw new IllegalArgumentException();
            index++;
        }

        while (nextNode != last) {
            front = front.next;
            nextNode = nextNode.next;
        }
        return front.value;
    }

    public int size() {
        return nodeCount;
    }

    public int[] toArray() {
        int [] array = new int[nodeCount];
        var searchNode = first;
        int index = 0;
        while (searchNode != null) {
            array[index] = searchNode.value;
            searchNode = searchNode.next;
            index++;
        }
        return array;
    }

    private boolean isEmpty() {
        return (first == null);
    }
}
