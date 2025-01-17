import java.util.*;

public class _2ClimbingStairs{

    //Tabulation 
    public static int climbStairs(int n){

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }

    //Memoization
    public static int climbStairsMemoization(int n, int dp[]){

        if(n == 0 || n== 1){
            return 1;
        }

        if(dp[n] != 0){ //already calculated
            return dp[n];
        }

        dp[n]=climbStairsMemoization(n-1,dp)+climbStairsMemoization(n-2, dp);

        return dp[n];
    }

    //Optimized
    public static int climbStairsOptimized(int n){
        if(n==1){
            return 1;
        }
        int first = 1;
        int second = 1;
        int third = 0;
        for(int i=2;i<=n;i++){
            third = first+second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(climbStairs(n));
        int dp[] = new int[n+1];
        System.out.println(climbStairsMemoization(n, dp));
        sc.close();
    }
}