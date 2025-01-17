package Stack_DSA;

import java.util.Stack;

public class Reverse_String {

    public static String reverseAString(String str){
        Stack<Character> s=new Stack<>();

        int idx=0;
        while (idx<str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");

        while (!s.empty()) {
            result.append(s.peek());
            s.pop();
        }
       return result.toString();
    }

    public static void main(String[] args) {
        
       System.out.println( reverseAString("!ssadab eht si hsehaM .srM"));
        
    }
    
}
