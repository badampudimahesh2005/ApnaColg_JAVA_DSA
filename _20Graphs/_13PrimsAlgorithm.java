import java.util.*;

public class _13PrimsAlgorithm{

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

    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

static class Pair implements Comparable<Pair> {
    int v;
    int cost;

    Pair(int v, int cost){
        this.v=v;
        this.cost=cost;
    }

   @Override
    public int compareTo(Pair p2){
        return this.cost - p2.cost;
    }
}


public static void primsAlgo(ArrayList<Edge> graph[]){
    
    boolean vis[] = new boolean[graph.length];

    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    pq.add(new Pair(0, 0));

    int finalCost = 0; // total minimum cost

    while(!pq.isEmpty()){
        Pair p= pq.remove();

        if(!vis[p.v]){
            vis[p.v]=true;
            finalCost += p.cost;

            for(Edge e: graph[p.v]){
                if(!vis[e.dest]){
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
    }

    //print final cost
    System.out.println("Final minimum cost of spanning tree is: "+finalCost);

}

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        primsAlgo(graph);
    }
}