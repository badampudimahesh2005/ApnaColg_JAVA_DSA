public class _7RodCutting {

    public static int rodCutting(int [] prices, int[] lengths, int rodLength){
        int n = prices.length;
        int [][] dp = new int[n+1][rodLength+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<n+1;i++){
            for(int j=1;j<rodLength+1;j++){
                int length = lengths[i-1];
                int price = prices[i-1];
                if(length <= j){
                    //including the length
                    int includeProfit = price + dp[i][j-length];
                    //excluding the length
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rodLength];

    }


    public static void main(String [ ] args){
        int [] prices = {1,5,8,9,10,17,17,20};
        int n = prices.length;
        int [] lengths = new int[n];
        for(int i=0;i<n;i++){
            lengths[i] = i+1;
        }
        int rodLength = 8;
        System.out.println("The maximum profit is: "+rodCutting(prices, lengths, rodLength));
    }
    
}
