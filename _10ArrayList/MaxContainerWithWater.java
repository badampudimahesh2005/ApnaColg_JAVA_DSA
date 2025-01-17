package ArrayList;

import java.util.ArrayList;


public class MaxContainerWithWater {
    

    //-----------brute force------------
    public static int storeWater(ArrayList<Integer> heights){
        int maxWater=0;

        for(int i=0;i<heights.size();i++){
            for(int j=i+1;j<heights.size();j++){
                int height=Math.min(heights.get(i), heights.get(j));
                int width=Math.abs(i-j);
                maxWater=Math.max(maxWater, width*height);
            }
        }
        return maxWater;
    }

    //------------Two pointer Approach-------------------
    public static int optimizedStoreWater(ArrayList<Integer>heights){
        int maxWater=0;

        int left=0;
        int right=heights.size()-1;
        while (left<right) {
            int height=Math.min(heights.get(left),heights.get(right));
            int width=right-left;
            maxWater=Math.max(maxWater, width*height);
            if(heights.get(left)<heights.get(right)){
                left++;
            }else{
                right--;
            }

        }
        return maxWater;
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> heights=new ArrayList<>();

        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        System.out.println(storeWater(heights));
        System.out.println(optimizedStoreWater(heights));

    }
}
