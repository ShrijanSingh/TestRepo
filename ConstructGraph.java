import java.util.*;
public class ConstructGraph
{
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt)
        {
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }

    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];
        for (int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        //0th VERTEX
        graph[0].add(new Edge (0,1,5));
        //1th VERTEX
        graph[1].add(new Edge (1,0,5));
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,3,3));
        //2nd VERTEX
        graph[2].add(new Edge (2,1,3));
        graph[2].add(new Edge (2,3,5));
        graph[2].add(new Edge (2,4,1));
        //3rd VERTEX
        graph[3].add(new Edge (3,1,3));
        graph[3].add(new Edge (3,2,4));
        //4th VERTEX
        graph[4].add(new Edge (4,2,1));
        //To Print the 2's Neighbours
        for (int i=0;i<graph[2].size();i++)
        {
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }

    }
}