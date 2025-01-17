package Arrays;

public class trappedRainwater {


    public static int  TrapingRainwater(int heights[]){

        int n=heights.length;
        //calculating leftmax array

        int leftmax[]=new int[n];
        leftmax[0]=heights[0];

        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1], heights[i]);
        }

        //calculating rightmax array
        int rightmax[]=new int[n];
        rightmax[n-1]=heights[n-1];

        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(heights[i], rightmax[i+1]);
        }

        //calculating trapped rain water
        int trappedwater=0;

        for(int i=0;i<n;i++){
            int waterlevel=Math.min(leftmax[i],rightmax[i]);

            trappedwater+=waterlevel-heights[i];
        }

        return trappedwater;
    }

    public static void main(String[] args){

        int heights[]={4,2,0,6,3,2,5};

        int res=TrapingRainwater(heights);
        System.out.println(res);


    }
    
}
 