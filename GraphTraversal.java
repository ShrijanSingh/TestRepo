import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class GraphTraversal {
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
    //Graph Traversal Using BFS
    public static void bfs (ArrayList<Edge> []graph)
    {
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty())
        {
            int curr=q.remove();
            if (!visited[curr])
            {
                System.out.print(curr+" ");
                visited[curr]=true;
                for (int i=0;i<graph[curr].size();i++)
                {
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //Graph Traversal using DFS
    public static void dfs(ArrayList<Edge> [] graph,int curr,boolean vis[])
    {
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest])
            {
                dfs(graph,e.dest,vis);
            }
        }
    }
    //Has Path from src to dest
    public static boolean hasPath (int src,int dest,ArrayList<Edge>[] graph,boolean vis[])
    {
        if (src==dest)
        return true;
        vis[src]=true;
        for (int i=0;i<graph[src].size();i++)
        {
            Edge e=graph[src].get(i);
            if (!vis[e.dest]){
            if ( hasPath(e.dest,dest,graph,vis))
            return true;
        }
    }
        return false;
    }
    //Cycle Detection in Graph
    public static boolean detectCycle(ArrayList<Edge>[] graph)
    {
        boolean vis[]=new boolean[graph.length];
        for (int i=0;i<graph.length;i++)
        {
            if (!vis[i])
            {
                if (detectCycleUtil(graph,vis,i,-1))
                return true;
            }
            
    }
    return false;
}
    //DFS Utility Function
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int curr,int par)
    {
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++)
        {
            Edge e=graph[curr].get(i);
            if (!vis[e.dest])
            {
                if (detectCycleUtil(graph,vis,e.dest,curr))
                {
                    return true;
                }
            else if(vis[e.dest])
            {
                if(e.dest!=par)
                return true;
            }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge>[] graph=new ArrayList[v];
        for (int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        // //0th VERTEX
        // graph[0].add(new Edge (0,1,5));
        // //1th VERTEX
        // graph[1].add(new Edge (1,0,5));
        // graph[1].add(new Edge(1,0,5));
        // graph[1].add(new Edge(1,3,3));
        // //2nd VERTEX
        // graph[2].add(new Edge (2,1,3));
        // graph[2].add(new Edge (2,3,5));
        // graph[2].add(new Edge (2,4,1));
        // //3rd VERTEX
        // graph[3].add(new Edge (3,1,3));
        // graph[3].add(new Edge (3,2,4));
        // //4th VERTEX
        // graph[4].add(new Edge (4,2,1));
        //To Print the 2's Neighbours
        for (int i=0;i<graph[2].size();i++)
        {
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
        }
        // BFS
        System.out.println("BFS traversal is as follows");
        bfs (graph);
        //DFS
        System.out.println();
        System.out.println("DFD traversal is as follows");
        boolean vis[]=new boolean[graph.length];
        dfs(graph, 0, vis);
        //Has Path from src to dest
        System.out.println();
        boolean res=hasPath(0,2,graph,new boolean[v]);
        System.out.println("The path from src to dest exists "+res);
        //Cycle Detection in Graph
        System.out.println();
        System.out.println("Has Cycle= "+detectCycle(graph));

    }

}
