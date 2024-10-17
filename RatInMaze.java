import java.util.*;
public class RatInMaze {
    public static void main(String [] args)
    {
        int n=0;
        int m=0;
        System.out.println("Enter row and coulumn of matrix");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int res=noOfWays(1,1,n,m);
        System.out.println("No of ways="+res);
    }
    public static int noOfWays(int sr,int sc,int er,int ec)
    {
        if (sr>er || sc>ec)
        return 0;
        if (sr==er || sc==ec)
        return 1;
        int downways=noOfWays(sr+1,sc,er,ec);
        int rightways=noOfWays(sr,sc+1,er,ec);
       int  totalways=downways+rightways;
        return totalways;
}
}
