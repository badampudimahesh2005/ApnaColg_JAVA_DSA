import java.util.*;
public class _3NearByCars {
    
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        int idx;

        public Point(int x,int y,int dist,int idx){
            this.x=x;
            this.y=y;
            this.dist=dist;
            this.idx=idx;

        }

        @Override
        public int compareTo(Point p2){
            return this.dist-p2.dist;
        }

    }
    public static void main(String[] args) {

        int cars[][]={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<cars.length;i++){
            int distsq=cars[i][0]*cars[i][0]+cars[i][1]*cars[i][1];
            pq.add(new Point(cars[i][0],cars[i][1],distsq,i));
        }

for(int i=k;i>0;i--){
    System.out.println("C"+pq.remove().idx);
}
        
    }
}
