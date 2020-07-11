package com.HackerRank;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTree {
    private Node root;
    private class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node= " + value;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        var current = root;
            while(true) {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = newNode;
                        break;
                    }
                    current = current.leftChild;
                }
                else {
                    if (current.rightChild == null) {
                        current.rightChild = newNode;
                        break;
                    }
                    current = current.rightChild;
                }

            }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (current.value < value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
}