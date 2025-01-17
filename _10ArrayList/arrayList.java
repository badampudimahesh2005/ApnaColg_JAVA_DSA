package ArrayList;

import java.util.ArrayList;

public class arrayList {
    
    public static void main(String[] args) {
        /* 
        ArrayList<String>  list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Boolean> list3=new ArrayList<>();

        //add ---O(1)
        list1.add("mahesh");
        list1.add("mahesh");
        list1.add("mahesh");

        list2.add(55);
        list3.add(true);

        System.out.println(list1);

        //get ----o(1)
        System.out.println(list1.get(0));

        //remove ----O(n)
        list1.remove(2);
        System.out.println(list1);

        //set ----O(n)
        list1.set(  0, "mohan");
        System.out.println(list1);

        //contains ---o(n)
        System.out.println(list1.contains("mahesh"));
        System.out.println(list1.contains("Babu"));

*/

ArrayList<ArrayList<Integer>> mainlist=new ArrayList<>();

ArrayList<Integer> list1=new ArrayList<>();
list1.add(1);
list1.add(2);
list1.add(3);

mainlist.add(list1);

ArrayList<Integer> list2=new ArrayList<>();
list2.add(2);
list2.add(4);
list2.add(6);
mainlist.add(list2);


for (int i = 0; i < mainlist.size(); i++) {
    ArrayList<Integer>currlist=mainlist.get(i);
    for (int j = 0; j < currlist.size(); j++) {
            System.out.println(currlist.get(j)+" ");

    }
    System.out.println();
}
System.out.println(mainlist);


    }
}
