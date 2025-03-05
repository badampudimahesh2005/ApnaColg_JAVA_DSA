public class _5UnboundedKnapsack {

    public static int unboundedKnapsackTabulation(int[] wt, int[] val, int W) {
        int n = val.length;

        int dp[][] = new int[n+ 1][W+ 1];
        for (int i = 0; i <dp.length ; i++) { //marking 0th row as 0
            dp[i][0] = 0;
        }
        for (int i = 0; i <dp[0].length ; i++) {//marking 0th column as 0
            dp[0][i] = 0;
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1]; //ith item value
                int w = wt[i-1]; //ith item weight

                if(w <= j){//including the item
                    int includeProfit = v + dp[i][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit,excludeProfit);
                }else{ //excluding the item
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][W];



    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(unboundedKnapsackTabulation(wt,val,W));
    }
}
