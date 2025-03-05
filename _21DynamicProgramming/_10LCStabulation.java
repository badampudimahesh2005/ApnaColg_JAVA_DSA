public class _10LCStabulation {

    public static int lcsTabulation(String s1, String s2){
        int n= s1.length();
        int m= s2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        return dp[n][m];
    }
    
    public static void main(String[] args) {
        String s1 ="abcdge";
        String s2="abedg";
        String s3="abcde";
        String s4="ace";

        System.out.println("max length of LCS of s1 and s2 is "+lcsTabulation(s1,s2));
        System.out.println("max length of LCS of s3 and s4 is "+lcsTabulation(s3,s4));
}

}