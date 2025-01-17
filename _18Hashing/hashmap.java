import java.util.HashMap;

public class hashmap {

    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tea", 10);
        map.put("Samosa", 15);
        map.put("Pizza", 250);
        map.put("Burger",  50);
        map.put("Coffee", 50);


        for(String k: map.keySet()){
            System.out.println("key: "+ k+ ",value: "+map.get(k));
        }

    }
}