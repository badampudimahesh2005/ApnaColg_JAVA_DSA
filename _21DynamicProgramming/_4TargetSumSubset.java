import java.util.*;
public class _4TargetSumSubset {



    //tabulation approach
    //Time complexity is O(n*target)
    //Space complexity is O(n*target)
    public static boolean  targetSumSubset(int arr[], int target){

        int n = arr.length;
        boolean dp[][] = new boolean[n+1][target+1];

        //if target is 0 then we can always get the target by not selecting any element. so marking 0th column as true
        //if n is 0 then we can never get the target sum. so marking 0th row as false
        // in java by default boolean array is false, but in cpp it is not. so we need to mark 0th row as false in cpp
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                int val = arr[i-1];
                //if the value is less than or equal to the target then we have two choices
                //1. include the element
                //2. exclude the element

                if(val <= j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                   
                }
                //if the value is greater than the target then we have only one choice
                //1. exclude the element               
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        print(dp);
        return dp[n][target];
    }

  
    //recursive approach
    //Time complexity is O(2^n)
    //Space complexity is O(n)
    public static boolean  targetSumSubsetRecursive(int arr[], int target, int i){
        //base case
        if(i == 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        int val = arr[i-1];
        //if the value is less than or equal to the target then we have two choices
        //1. include the element
        //2. exclude the element
        if(val <= target){
            return targetSumSubsetRecursive(arr,target-val,i-1) || targetSumSubsetRecursive(arr,target,i-1);
        }
        //if the value is greater than the target then we have only one choice
        //1. exclude the element
        else{
            return targetSumSubsetRecursive(arr,target,i-1);
        }
    }


    //memoization approach
    //Time complexity is O(n*target)
    //Space complexity is O(n*target)
    public static boolean  targetSumSubsetMemoization(int arr[], int target, int i, boolean dp[][]){
        //base case
        if(i == 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dp[i][target] != false){
            return dp[i][target] == true;
        }   
        int val = arr[i-1];
        //if the value is less than or equal to the target then we have two choices
        //1. include the element
        //2. exclude the element
        if(val <= target){
            dp[i][target] = (targetSumSubsetMemoization(arr,target-val,i-1, dp) || targetSumSubsetMemoization(arr,target,i-1,dp)) ? true: false;
            }
        //if the value is greater than the target then we have only one choice
        //1. exclude the element
        else{
            dp[i][target] = targetSumSubsetMemoization(arr,target,i-1,dp) ? true : false;
        }
        return dp[i][target] == true;
    }


    

    public static void print(boolean dp[][]){
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j <dp[0].length ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        int target = 10;
        System.out.println("Tabulation approach: "+targetSumSubset(arr,target));
        System.out.println("Recursive approach: "+targetSumSubsetRecursive(arr,target,arr.length));
        boolean dp[][] = new boolean[arr.length+1][target+1];
        System.out.println("Memoization approach: "+targetSumSubsetMemoization(arr,target,arr.length-1,dp));
    }
    
}
