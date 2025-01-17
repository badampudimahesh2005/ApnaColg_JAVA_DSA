public class spiralmatrix {

    public static void SpiralMatrix(int[][] arr){

        int startrow=0;
        int endrow=arr.length-1;
        int startcol=0;
        int endcol=arr[0].length-1;

        while(startrow<=endrow && startcol<=endcol){
  //top
            for(int i=startcol;i<=endcol;i++){
                System.out.print(arr[startrow][i]+" ");
            }

            //right
            for(int j=startrow+1;j<=endrow;j++){
                System.out.print(arr[j][endcol]+" ");

            }
            //bottom
            for(int i=endcol-1;i>=startcol;i--){
                if(startrow==endrow){
                    return;
                }
                System.out.print(arr[endrow][i]+" ");

            }

            //left
            for(int j=endrow-1;j>=startrow+1;j--){
                if(startcol==endcol){
                    return;
                }
                System.out.print(arr[j][startcol]+" ");

            }
            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }
        System.out.println();
    }

    public static void main(String[] args){
        int matrix[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        SpiralMatrix(matrix);
 
    }
    
}
