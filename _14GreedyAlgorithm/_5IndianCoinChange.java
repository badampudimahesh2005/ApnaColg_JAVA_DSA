import java.util.*;

public class _5IndianCoinChange {

    public static int minCoins(int[]coins,int V){
        int n=coins.length;
        Arrays.sort(coins);
        int res=0;
        for(int i=n-1;i>=0;i--){
            int count=V/coins[i];
            res+=count;
            V=V%coins[i];
            }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int amount = 590;
        System.out.println("minimum number of coins required: "+minCoins(coins, amount));
    }
    
}
