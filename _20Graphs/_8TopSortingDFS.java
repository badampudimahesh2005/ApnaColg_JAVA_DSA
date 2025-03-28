import java.util.*;

public class _8TopSortingDFS {

    static class Edge{
        int src;
        int dest;

        Edge(int source, int destination){
            this.src=source;
            this.dest=destination;
        }
    }


    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

      graph[2].add(new Edge(2,3));

      graph[3].add(new Edge(3,1));

      graph[4].add(new Edge(4,0));
      graph[4].add(new Edge(4,1));

      graph[5].add(new Edge(5,0));
      graph[5].add(new Edge(5,2));

    }


    public static void topSorting(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortingUtil(graph, i, vis, st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void topSortingUtil(ArrayList<Edge> graph[], int src, boolean vis[], Stack<Integer> st){
        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                topSortingUtil(graph, e.dest, vis, st);
            }
        }
        st.push(src);
    }
    public static void main(String[] args) {
        int v=6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        topSorting(graph);
    }
    
}
