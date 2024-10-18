import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        System.out.println("Enter row and coulumn of matrix");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        boolean visited[][]=new boolean[n][m];
        noOfWays(0, 0, n-1, m-1, "",visited);
        // System.out.println("No of ways="+res);

    }

    public static void noOfWays(int sr, int sc, int er, int ec, String s,boolean visited[][]) {
       
        if (sr<0 || sc<0)
        return;
        if (sr > er || sc > ec)
            return;
            if (visited[sr][sc]==true)
            return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        visited[sr][sc]=true;
        // go right
        noOfWays(sr + 1, sc, er, ec, s + "R",visited);
        // go down
        noOfWays(sr, sc + 1, er, ec, s + "D",visited);
        // go left 
        noOfWays(sr-1, sc, er, ec, s+"L", visited);
        // go up
    noOfWays(sr, sc+1, er, ec, s+"R", visited);
    visited[sr][sc]=false;
}
}
