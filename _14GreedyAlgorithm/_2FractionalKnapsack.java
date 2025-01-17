import java.util.*;

public class _2FractionalKnapsack {

    public static void main(String[] args) {

        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];
        //0th column: index , 1st column: ratio

        for(int i=0;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)wt[i];
        }

        //Asscending order of ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1])); //Sorting on the basis of ratio

        int capacity = W;
        int finalVal =0;

        for(int i=ratio.length-1; i>=0; i--){ //Iterating from highest ratio to lowest ratio

            int idx= (int)ratio[i][0];
            if(wt[idx]<= capacity){ //include whole item
                capacity = capacity - wt[idx];
                finalVal += val[idx];     
            }else{ //include fraction of item
                finalVal += (capacity*ratio[i][1]);
                capacity =0;
                break;
            }
        }

        System.out.println("Final Value: "+finalVal);

    }
    
}
