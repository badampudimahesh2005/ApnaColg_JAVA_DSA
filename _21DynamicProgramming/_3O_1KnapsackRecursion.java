import java.util.*;

public class _3O_1KnapsackRecursion{

    public static int knapSack(int wt[], int val[], int w, int i){
        if(i==0 || w==0){
            return 0;
        }

        if(wt[i-1] <= w){

            //include
            int ans1 = val[i-1]+ knapSack(wt,val,w-wt[i-1],i-1);
            //exclude
            int ans2 = knapSack(wt,val,w,i-1);

            return Math.max(ans1,ans2);
        }else{
            return knapSack(wt,val,w,i-1);
        }
    }
    

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;

        System.out.println(knapSack(wt,val,W,val.length));
       
    }
}