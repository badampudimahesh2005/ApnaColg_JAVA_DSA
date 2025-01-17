import java.util.*;

public class _15ConnectedCitiesWithMinCost {

    static class Edge implements Comparable<Edge>{
        int  dest, weight;

        Edge( int destination, int weight){
          
            this.dest=destination;
            this.weight=weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }


public static int connectedCities(int cities[][]){

    int n=cities.length;

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[n];

    pq.add(new Edge(0,  0));
    int finalcost=0;

    while(!pq.isEmpty()){
        Edge e = pq.remove();

        if(!vis[e.dest]){
            vis[e.dest]=true;
            finalcost+=e.weight;

            //neighbours
            for(int i=0;i<cities[e.dest].length;i++){
                if(cities[e.dest][i]!=0 ){
                    pq.add(new Edge( i, cities[e.dest][i]));
                }
        }

    }
}
return finalcost;

}


    public static void main(String args[]){

        int cities[][]={
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        System.out.println(connectedCities(cities));


    }
}