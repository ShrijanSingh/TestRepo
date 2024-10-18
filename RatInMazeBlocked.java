import java.util.Scanner;
public class RatInMazeBlocked {
    public static void main(String[] args) {
        
    //  int n = 0;
        // int m = 0;
        // System.out.println("Enter row and coulumn of matrix");
        // Scanner sc = new Scanner(System.in);
        // n = sc.nextInt();
        // m = sc.nextInt();
        // boolean visited[][]=new boolean[n][m];
        int maze[][]={{1,0,1,1},
                        {1,1,1,1},
                        {1,1,0,1}};
    
        noOfWays(0, 0, maze.length-1, maze[0].length-1, "",maze);
        // System.out.println("No of ways="+res);

    }
    public static void noOfWays(int sr, int sc, int er, int ec, String s,int maze[][]) {
       
        if (sr<0 || sc<0)
        return;
        if (sr > er || sc > ec)
            return;
           
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        if (maze[sr][sc]==0)
        return;
        if (maze[sr][sc]==-1)
        return;
        // go right
        maze[sr][sc]=-1;
        noOfWays(sr + 1, sc, er, ec, s + "R",maze);
        // go down
        noOfWays(sr, sc + 1, er, ec, s + "D",maze);
        // go left 
        noOfWays(sr-1, sc, er, ec, s+"L", maze);
        // go up
    noOfWays(sr, sc+1, er, ec, s+"R", maze);
    maze[sr][sc]=1;
}
}
