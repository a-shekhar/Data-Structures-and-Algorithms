package org.queues;

import java.util.Stack;

/*
Show	how	to	implement	one	queue	efficiently	using	two	stacks.	Analyze	the
 running	time	of	the	queue	operations - Leetcode 232
 */
public class QueueUsingStacks {
    Stack<Integer> pushed = new Stack<>();
    Stack<Integer> popped = new Stack<>();
    public void push(int x) {
        while(!popped.isEmpty()){
            pushed.push(popped.pop());
        }
        pushed.push(x);
    }

    public int pop() {
        while (!pushed.isEmpty()) {
            popped.push(pushed.pop());
        }
        return popped.pop();
    }

    public int peek() {
        while (!pushed.isEmpty()) {
            popped.push(pushed.pop());
        }
        return popped.peek();
    }

    public boolean empty() {
        return pushed.isEmpty() && popped.isEmpty();
    }
}
