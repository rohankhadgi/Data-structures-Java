package com.HackerRank;

import java.util.Queue;

public class QueueReverser {
    private Queue<Integer> Q;
    private int k;
    private Stack<Integer> stack = new Stack<>();


    public QueueReverser(Queue<Integer> Q, int k) {
        this.Q = Q;
        this.k = k;
    }

    public void reverse() {
            for (int i = 0; i < k; i++)
                stack.push(Q.remove());
            while(!stack.isEmpty())
                Q.add(stack.pop());
            for (int i = k; i < Q.size(); i++)
                Q.add(Q.remove());
    }

    @Override
    public String toString() {
        return Q.toString();
    }
}
