public class _9LCSmemoization {

    //memoization method
    public static int lcsMemoization(String s1, String s2,int n, int m, int[][] memo){

        //base case
        if(n==0  || m==0){
            return 0;
        }

        if(memo[n][m]!=-1){
            return memo[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return memo[n][m] = 1 + lcsMemoization(s1, s2, n-1, m-1, memo);
        }
        else{
            return memo[n][m] = Math.max(lcsMemoization(s1, s2, n-1, m, memo), lcsMemoization(s1, s2, n, m-1, memo));
        }


    }
    

    public static void main(String[] args) {
        String s1 ="abcdge";
        String s2="abedg";
        String s3="abcde";
        String s4="ace";
        int n=s1.length();
        int m=s2.length();
        
        int memo[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                memo[i][j]=-1;
            }
        }

        int memo2[][] = new int[s3.length()+1][s4.length()+1];
        for(int i=0;i<s3.length()+1;i++){
            for(int j=0;j<s4.length()+1;j++){
                memo2[i][j]=-1;
            }
        }

        System.out.println("max length of LCS of s1 and s2 is "+lcsMemoization(s1,s2,n,m, memo));
        System.out.println("max length of LCS of s3 and s4 is "+lcsMemoization(s3,s4,s3.length(),s4.length(), memo2));
}
}
