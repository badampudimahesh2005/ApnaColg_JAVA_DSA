import java.util.Arrays;
import java.util.HashSet;

public class _12LongestIncreasingSubsequence {


    public static int lcsTabulation(int [] arr1, int [] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        //initialization
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=m; i++) {
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                    }
            }
        }

        return dp[n][m];

    }


    public static int lis(int arr[]){

        //to store unique elements
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];//to store unique elements
        int index=0;
        for(int i:set){
            arr2[index++]=i;
        }
        Arrays.sort(arr2);//sorting the array

        return lcsTabulation(arr,arr2);

    }


    public static void main(String args[]){

        int arr[]= {50, 3, 10, 7, 40, 80};

        System.out.println("===========Length of Longest Increasing Subsequence is "+lis(arr)+"===========");
       

    }
    
}
