package org.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if (ch == ')' && !stack.empty() && stack.peek() == '('){
                stack.pop();
            }else if (ch == ']'  && !stack.empty() && stack.peek() == '['){
                stack.pop();
            }else if (ch == '}'  && !stack.empty() && stack.peek() == '{'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid("()"));
        System.out.println(parentheses.isValid("({})"));
        System.out.println(parentheses.isValid("({)})"));
    }
}
