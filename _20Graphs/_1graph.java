import java.util.*;


public class _1graph {

   public static class Edge{
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
   }
    public static void main(String[] args) {
        
      

        int v=5;

        ArrayList<Edge>[] graph = new ArrayList[v];
        //ArrayList<Edge>[] graph = new ArrayList[v];, it doesn't automatically create instances of ArrayList at each index.
        // Instead, it creates an array of null references.

        //If you try to use graph[i] without initializing it, you'll get a NullPointerException because graph[i] is still null

        //By doing graph[i] = new ArrayList<>();, you're creating a new instance of ArrayList and assigning it to the i-th index of the graph array.

       
        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<>();
        } 

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));


        //2's neighbours
        for(Edge e: graph[2]){
            System.out.println(e.source + " " + e.destination + " " + e.weight);
        }
    }
}