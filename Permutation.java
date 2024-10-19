import java.util.*;
public class Permutation {
    public static void main(String[] args) {
        String s="abc";
        List<String> l=new ArrayList<>();
        printp(s,"",l);
        for (String s1:l)
        System.out.println(s1);
    }
    public static void printp(String str,String t,List<String> l)
    {
        if (str.equals(""))
        {
            l.add(t);
            return;
        }
        for (int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            String left=str.substring(0, i);
            String right=str.substring(i+1);
            String rem=left+right;
            printp (rem,t+ch,l);
        }
    }
}
