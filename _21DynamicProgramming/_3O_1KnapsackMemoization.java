public class _3O_1KnapsackMemoization {

    public static int knapSack(int wt[], int val[], int w, int i, int dp[][]){
        if(i==0 || w==0){
            return 0;
        }

        if(dp[i][w]!= -1){
            return dp[i][w];
        }

        if(wt[i-1] <= w){

            //include
            int ans1 = val[i-1]+ knapSack(wt,val,w-wt[i-1],i-1,dp);
            //exclude
            int ans2 = knapSack(wt,val,w,i-1,dp);

            dp[i][w]= Math.max(ans1,ans2);
            return dp[i][w];
        }else{
            dp[i][w]= knapSack(wt,val,w,i-1,dp);
            return dp[i][w];
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]= -1;
            }
        }
        System.out.println(knapSack(wt,val,W,val.length, dp));
    }
    
}
