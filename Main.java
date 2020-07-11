package com.HackerRank;
import java.util.LinkedList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(15);
        tree.insert(12);
        tree.insert(18);
        tree.insert(17);
        tree.insert(8);
        tree.traversePostOrder();
    }
}