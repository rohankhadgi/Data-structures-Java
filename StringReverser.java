package com.HackerRank;

import java.util.Arrays;
import java.util.Stack;

public class StringReverser {
    public void reverser(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch: str.toCharArray())
            stack.push(ch);

        StringBuffer reverseString = new StringBuffer();
        while (!stack.empty()) {
            reverseString.append(stack.pop());
        }
    }
}
