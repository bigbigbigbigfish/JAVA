package day2;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(isValid("{"));
    }

    private static boolean isValid(String s) {
        if(s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for(int i= 0; i<s.length() ;i++) {
            char c = s.charAt(i);
            if(c =='[' || c =='(' || c=='{') {
                stack.push(c);
            }
            if( c ==']' || c =='}'|| c ==')') {

                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if(top =='[' && c !=']' || top =='{'&& c!='}' || top =='('&&c !=')' ) {
                    return false;
                }
            }
        }return stack.isEmpty();
    }
}


