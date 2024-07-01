package org.stacks;

class StackUsingArray{

    public static final int MAX_CAPACITY = 10;
    int top = -1;
    int[] stack;
    int size;

    public StackUsingArray(){
        stack = new int[MAX_CAPACITY];
        size = 0;
    }
    public void push(int value) {
        if(top == MAX_CAPACITY - 1){
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = value;
        size++;
        System.out.println("Pushed value: " + value + " at " + top);
    }

    public int pop(){
        if(size <= 0){
            throw new RuntimeException("Stack is empty");
        }
        int value = stack[top];
        size--;
        top--;
        System.out.println("Popped value: " + value);
        return value;
    }

    public int peek(){
        if(size <= 0){
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public int getSize(){
        return top+1; // as index starts from 0
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public String toString(){
        StringBuffer result = new StringBuffer();
        for(int i = 0; i <= top; i++){
            result.append(stack[i] + " ");

        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
        System.out.println("Stack is empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.getSize());
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println("Stack size: " + stack.getSize());
        stack.push(13);
        System.out.println(stack.toString());
    }
}