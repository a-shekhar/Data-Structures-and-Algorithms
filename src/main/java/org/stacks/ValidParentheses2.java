package org.stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses2 {
    public boolean isValid(String expression) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char ch : expression.toCharArray()){
            if(ch == ')' || ch == ']' || ch == '}'){
                if(stack.isEmpty() || stack.pop() != map.get(ch)){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size() == 0;
    }
    public static void main(String[] args) {
        ValidParentheses2 parentheses = new ValidParentheses2();
        System.out.println(parentheses.isValid("()"));
        System.out.println(parentheses.isValid("({})"));
        System.out.println(parentheses.isValid("({)})"));
    }
}
