import java.util.Stack;

public class DuplicateParentheses {


    public static boolean hasDupicateParentheses(String s){
        Stack<Character> st= new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr= s.charAt(i);
            if(curr==')'){
                int count=0;
                while ( /* !st.empty()*/st.peek()!='(') {
                    //why we are not includin stack empty case ,because 
                    //string is valid ,means if open bracket is there then there should be closing bracket                   
                    st.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                st.pop();//to remove '('
            }else{
                st.push(curr);
            }
        }
        return false;

    }
    public static void main(String[] args) {
         
        String s1="(((a+(b)))+(c+d))"; //true
        String s2="((a+b)+(c+d))";//false

        System.out.println(hasDupicateParentheses(s1));
        System.out.println(hasDupicateParentheses(s2));
    }
}