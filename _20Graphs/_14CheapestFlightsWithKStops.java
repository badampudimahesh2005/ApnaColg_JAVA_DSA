import java.util.*;

class _14CheapestFlightsWithKStops {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int source, int destination, int weight){
            this.src=source;
            this.dest=destination;
            this.wt=weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int flights[][]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph[u].add(new Edge(u, v, w));
        }

      
        
    }

    static class Info{
        int vtx;
        int cost;
        int stops;

        Info(int vtx, int cost, int stops){
            this.vtx=vtx;
            this.cost=cost;
            this.stops=stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k ){
         ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];
        int ans=0;

        //initialize all distances to infinity
        for(int i=0;i<n;i++){
            if(i != src)
            dist[i]=Integer.MAX_VALUE;

        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            ans=curr.stops;
            

            
            if(curr.stops > k){
                break;
            }

            for(int i=0;i<graph[curr.vtx].size();i++){
                Edge e = graph[curr.vtx].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                // if(dist[u]!= Integer.MAX_VALUE && dist[u]+wt<dist[v] && curr.stops<=k){
                //     dist[v]=dist[u]+wt;
                //     q.add(new Info(v, dist[v], curr.stops+1));
                //     }
                 if( curr.cost+wt<dist[v] && curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                    }
                
            }
        }
        return dist[dest]==Integer.MAX_VALUE ? -1 : dist[dest];

    }

    public static void main(String[] args) {
        int n = 4;
       

        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0, dest=3, k=1;

        System.out.println("Cheapest flight cost from "+src+" to "+dest+" with atmost "+k+" stops is: "+findCheapestPrice(n, flights, src, dest, k));


        
    }
}

/*

import java.util.*;

public class CheapestFlights {

    static class Flight {
        int city;
        int cost;
        int stops;

        Flight(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        // Priority queue to store flights based on cost
        PriorityQueue<Flight> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.cost));
        pq.add(new Flight(src, 0, 0));

        // Array to track the minimum cost to reach each city
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!pq.isEmpty()) {
            Flight current = pq.poll();

            // If we reach the destination
            if (current.city == dest) {
                return current.cost;
            }

            // If we exceed the number of stops, continue
            if (current.stops > k) {
                continue;
            }

            // Explore all flights from the current city
            for (int[] flight : flights) {
                if (flight[0] == current.city) {
                    int nextCity = flight[1];
                    int nextCost = current.cost + flight[2];
                    int nextStops = current.stops + 1;

                    // If the new cost is cheaper and within the stop limit
                    if (nextCost < minCost[nextCity] && nextStops <= k + 1) {
                        minCost[nextCity] = nextCost;
                        pq.add(new Flight(nextCity, nextCost, nextStops));
                    }
                }
            }
        }

        // If destination is unreachable
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dest = 3, k = 1;

        System.out.println("Cheapest flight cost from " + src + " to " + dest + " with at most " + k + " stops is: " + findCheapestPrice(n, flights, src, dest, k));
    }
}
 */