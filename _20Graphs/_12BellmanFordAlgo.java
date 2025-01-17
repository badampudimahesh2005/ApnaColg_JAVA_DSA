import java.util.*;

public class _12BellmanFordAlgo {

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

       graph[0].add(new Edge(0, 1, 2));
       graph[0].add(new Edge(0, 2, 4));

       graph[1].add(new Edge(1, 2, -4));

       graph[2].add(new Edge(2, 3, 2));

       graph[3].add(new Edge(3, 4, 4));

       graph[4].add(new Edge(4, 1, -1));

        
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src){

        int dist[] = new int[graph.length];//dist-> src to i
        //initialize all distances to infinity
        for(int i=0;i<dist.length;i++){
            if(i != src)
            dist[i]=Integer.MAX_VALUE;
        }

        int V = graph.length;

        //relaxation TC:O(V-1)*O(E) => O(V*E)
        for(int i=0;i<V-1;i++){
            //edges TC:O(E)
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if( dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v] ){
                        dist[v] = dist[u]+wt;
                    }
                 }
            }
        }

        //print the calculated shortest distances
        for(int i=0;i<dist.length;i++){
            System.out.println("Distance of "+i+" from source is "+dist[i]);
        }

    }

    public static void main(String[] args) {
        
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        bellmanFord(graph, 0);


    }
    
}
