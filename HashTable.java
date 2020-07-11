package com.HackerRank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashTable {
    private LinkedList<Entry>[] hashTable = new LinkedList[5];

    public void put(int k, String v) {
        var index = hash(k);
        if (hashTable[index] == null)
            hashTable[index] = new LinkedList<>();

        var bucket = hashTable[index];
        for (var newEntry : bucket) {
            if (newEntry.key == k) {
                newEntry.value = v;
                return;
            }
        }
        bucket.addLast(new Entry(k,v));
    }

    public String get(int k) {
        var index = hash(k);
        var list = hashTable[index];
        String value = null;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                var getEntry = list.get(i);
                if (getEntry.key == k) {
                    value = getEntry.value;
                    break;
                }
            }
        }
        return value;
    }

    public String remove(int k) {
        var index = hash(k);
        var list = hashTable[index];
        String value = null;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                var getEntry = list.get(i);
                if (getEntry.key == k) {
                    value = getEntry.value;
                    list.remove(i);
                    break;
                }
            }
        }
        hashTable[index] = list;
        return value;
    }

    private int hash(int k) {
        return k % hashTable.length;
    }

    private class Entry {
        private int key;
        private String value;
        public Entry(int k, String v) {
            key = k;
            value = v;
        }
    }
}

