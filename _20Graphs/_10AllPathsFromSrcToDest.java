
import java.util.*;

public class _10AllPathsFromSrcToDest {

    static class Edge{
        int src;
        int dest;

        Edge(int source, int destination){
            this.src=source;
            this.dest=destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        // Create a graph with 6 vertices
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        // Add edges to the graph
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    
    public static void printAllPaths(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path+src+"->");
        }
    }
    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        printAllPaths(graph, 5, 1, "");


    }
    
}
