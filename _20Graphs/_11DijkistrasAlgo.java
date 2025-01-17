import java.util.*;

public class _11DijkistrasAlgo {

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

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
        
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int path;

        public Pair(int node, int path){
            this.node=node;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path-p2.path; //path based sorting for my pairs 
        }
    }

    public static void dijkistra(ArrayList<Edge> graph[], int src){

        int dist[] = new int[graph.length];//dist-> src to i

        //initialize all distances to infinity
        for(int i=0;i<dist.length;i++){
            if(i != src)
            dist[i]=Integer.MAX_VALUE;
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop
        while(!pq.isEmpty()){
            Pair p = pq.remove();

            if(!vis[p.node]){
                vis[p.node]=true;
                //Neighbours
                for(int i=0;i<graph[p.node].size();i++){
                    Edge e = graph[p.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(!vis[v] && dist[v] > dist[u] + wt){//updated distance is less than previous distance
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                        } 
                }
            }
           
        }

        // Print shortes distances from src to vertices
        for(int i=0;i<dist.length;i++){
            System.out.println("Distance from "+src+" to "+i+" is "+dist[i]);
        }


    }

    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);

        dijkistra(graph, 0);

        
    }
    
}
