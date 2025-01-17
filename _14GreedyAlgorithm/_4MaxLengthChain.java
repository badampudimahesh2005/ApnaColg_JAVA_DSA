import java.util.*;

public class _4MaxLengthChain {

    public static int maxChainLength(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));//sort by second element of each pair

        int maxLen=1;
        int pairEnd = pairs[0][1];//last element of first pair //chaind end

        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > pairEnd) {
                maxLen++;
                pairEnd = pairs[i][1];
            }
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        System.out.println("maximum length of chain: "+maxChainLength(pairs));
    }
    
}
