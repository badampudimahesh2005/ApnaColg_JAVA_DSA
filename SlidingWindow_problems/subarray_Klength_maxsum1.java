/**
 * subarray_Klength_maxsum1
 */
public class subarray_Klength_maxsum1 {


    public static int  bruteforce(int arr[],int k){
        int max=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<arr.length-k+1;i++){
            for(int j=i;j<i+k;j++){
                sum+=arr[j];
            }
            max=Math.max(max, sum);
            sum=0;
        }
         
        return max;
    }

    public static int optimized(int arr[],int k){
        int max=Integer.MIN_VALUE;
        int sum=0;

        //calculate the first subarray of length k
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        max=Math.max(max, sum);

        //calculate max sum of the remaining subarray 
        for(int i=k;i<arr.length;i++){
            sum=sum - arr[i-k] + arr[i];
            max=Math.max(max, sum);
        }

        return max;
    }
    public static void main(String[] args) {
        int arr[]={4,9,2,-1,0,7};
        int k=3;
        int arr2[]={100,200,300,400};

        System.out.println(bruteforce(arr,k)); 
        System.out.println(optimized(arr, k));
        System.out.println(optimized(arr, 4));       
    }
}