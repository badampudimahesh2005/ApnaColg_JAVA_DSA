package ArrayList;

import java.util.ArrayList;



public class PairSum {

    public static boolean findPairSum(ArrayList<Integer> list,int target){

        boolean found =false;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j) == target){
                    found=true;
                    break;
                }
            }
        }
        return found;
    }

    public static boolean optimizedPairSum(ArrayList<Integer> list,int target){
        int i=0;
        int j=list.size()-1;
        boolean found =false;

        while (i<j) {
            int sum=list.get(i)+list.get(j);
            if( sum== target){
                System.out.println("["+list.get(i)+", "+list.get(j)+"]");
                found=true;
                break;

            }
            else if(sum>target){
                j--;
            }else{
                i++;
            }
        }

        return found;
        }
    
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        // System.out.println(findPairSum(list, 5));
        // System.out.println(findPairSum(list, 2));

        System.out.println (optimizedPairSum(list, 5));
        System.out.println(optimizedPairSum(list, 2));




        

    }
}
