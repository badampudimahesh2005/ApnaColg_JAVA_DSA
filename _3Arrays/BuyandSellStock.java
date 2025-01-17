package Arrays;

public class BuyandSellStock {

    public static int bestTimeToBuyStock(int prices[]){

        int n=prices.length;
        int maxprofit=0 ;

        int rightmax[]=new int[n];

         rightmax[n-1]=prices[n-1];

        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],prices[i]);
        
        }
       

        for(int i=0;i<n;i++){
            int profit=rightmax[i]-prices[i];
           

            maxprofit=Math.max(maxprofit, profit);
        }
        return maxprofit;
    }

    public static int optimized(int prices[]){

        int n=prices.length;
        int maxprofit=0;
        int buyPrice=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                maxprofit=Math.max(maxprofit, profit);

            }else{
                buyPrice=prices[i];
            }
        }

        return maxprofit;

    
    }

    public static void main(String[] args){

        int prices[]={3,2,6,5,0,3};

        System.out.println(bestTimeToBuyStock(prices));
        System.out.println(optimized(prices));


    }
    
}
