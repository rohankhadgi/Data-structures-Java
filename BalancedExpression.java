package com.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private final List<Character> close = Arrays.asList(')','}',']','>');
    private final List<Character> open = Arrays.asList('(','{','[','<');

    public boolean evaluate(String exp) {
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (isOpenExpression(ch)) {
                stack.push(ch);
            }
            else if (isCloseExpression(ch)) {
                if (stack.empty())
                    return false;
                char open = stack.pop();
                if (!bracketsMatch(ch, open))
                    return false;
            }
        }
        return stack.empty();
    }

    private boolean bracketsMatch(char ch, char open) {
        return (close.indexOf(ch) == this.open.indexOf(open));
    }

    private boolean isCloseExpression(char ch) {
        return close.contains(ch);
    }

    private boolean isOpenExpression(char ch) {
        return open.contains(ch);
    }
}
