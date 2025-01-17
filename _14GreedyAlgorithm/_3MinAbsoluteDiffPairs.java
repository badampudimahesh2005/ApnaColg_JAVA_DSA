import java.util.*;;

public class _3MinAbsoluteDiffPairs {
    public static void main(String[] args) {

        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        int minAbsDiff =0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            minAbsDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Min Absolute Difference: "+minAbsDiff);

    }

    
}
