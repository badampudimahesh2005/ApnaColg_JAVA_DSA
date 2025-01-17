package ArrayList;

import java.util.ArrayList;

public class PairSumTwo {

    public static Boolean findPairSum(ArrayList<Integer> list,int target){
        boolean found=false;
        int bp=-1;
        for (int i = 0; i < list.size(); i++) {
                if(list.get(i)>list.get(i+1)){
                    bp=i;
                    break;
                }
        }

        int left=bp+1;
        int right=bp;
        int n=list.size();
        while (left!=right) {
            int sum=list.get(left)+list.get(right);
            if(sum==target){
                System.out.println("["+list.get(left)+", "+list.get(right)+"]");
                found=true;
                break;
            }else if(sum<target){
                left=(left+1)%n;

            }else{
                right=(n+right-1)%n;
            }
        }


        return found;

    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list =new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(findPairSum(list, 16));
    }
}
