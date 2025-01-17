import java.util.Stack;



public class ValidParentheses {

    public static boolean isValidParentheses(String s){
        Stack<Character> stack= new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
        if(curr =='(' || curr =='{' || curr =='['){
            stack.push(curr);
        }else{
            if (stack.isEmpty()) {
                return false;
            }

            if( 
                (curr==')' && stack.peek()=='(') || (curr==']' && stack.peek()=='[') || (curr=='}' && stack.peek()=='{') ){
                stack.pop();
            }else{
                return false;
            }
        }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
        
    }

    public static void main(String[] args) {

        String s1="({[]}())";
        String s2="({[}])";
        String s3="({})[]";
        

        System.out.println(isValidParentheses(s1));
        System.out.println(isValidParentheses(s2));
        System.out.println(isValidParentheses(s3));


        
    }
}