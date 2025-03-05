public class _11LongestCommonSubstring {

    //Tabulation method
    public static int lcsTabulation(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        int max = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                    max = Math.max(max,dp[i][j]);

            }else{
                //if characters are not equal then length of common substring will be 0
                dp[i][j] = 0;
            }

        }
    }
    //why we are returning max instead of dp[n][m]?
    //because dp[n][m] will not give us the length of longest common substring
    //it will give us the length of longest common substring ending at s1[n] and s2[m]
    //so we are storing the max length of common substring in max variable
    

    return max;
}
    

    public static void main(String[] args) {
        String s1 ="abcde";
        String s2 ="abgcde";

        System.out.println("Length of longest common substring is "+lcsTabulation(s1,s2));

    }
}
