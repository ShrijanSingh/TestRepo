import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        int n = 0;
        int m = 0;
        System.out.println("Enter row and coulumn of matrix");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        noOfWays(1, 1, n, m, "");
        // System.out.println("No of ways="+res);
    }

    public static void noOfWays(int sr, int sc, int er, int ec, String s) {
        if (sr > er || sc > ec)
            return;
        if (sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        noOfWays(sr + 1, sc, er, ec, s + "D");
        noOfWays(sr, sc + 1, er, ec, s + "R");

    }
}
