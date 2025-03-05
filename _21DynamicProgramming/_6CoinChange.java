public class _6CoinChange {

    public static int coinChange(int[] coins, int amount) {

        int n=coins.length;

        int [][] dp = new int[n+1][amount+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<= n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    //including the coi -> dp[i][j-coins[i-1]] 
                    //excluding the coin -> dp[i-1][j]
                    // total ways = including + excluding 
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else{
                    //if the coin is larger than the amount, we cannot include it
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        return dp[n][amount];
  
    }
   


    public static void main(String[] args) {
        int[] coins = {2,5,3,6};

        int amount = 10;
        System.out.println("The number of ways to make the amount is: "+coinChange(coins, amount));

        int [] coins2 = {1,2,3};
        int amount2 = 4;
        System.out.println("The number of ways to make the amount is: "+coinChange(coins2, amount2));
    }
    
}
