
import java.util.*;
public class _8LCSrecursion {

    public static int LCS(String s1, String s2, int n, int m){

        //base case
        if(n==0 || m==0){
            return 0;
        }


        //first case if last char is equal
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1 + LCS(s1, s2, n-1, m-1);
        }else{
            //second case if last char is not equal
            return Math.max( LCS(s1, s2, n-1, m), LCS(s1, s2, n, m-1) );
        }
    }

    public static void main(String[] args) {
        String s1 ="abcdge";
        String s2="abedg";
        String s3="abcde";
        String s4="ace";
        int n=s1.length();
        int m=s2.length();

        System.out.println("max length of LCS of s1 and s2 is "+LCS(s1,s2,n,m));
        System.out.println("max length of LCS of s3 and s4 is "+LCS(s3,s4,s3.length(),s4.length()));
}
}