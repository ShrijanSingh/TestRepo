
public class TreeCreations {
    public static class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
    }
}
static int idx=-1;
    public static void main(String[] args) {
        int ar[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=buildTree(ar);
        System.out.println(root.data);


    }
    public static Node buildTree(int node[])
    {
        idx++;
        if (node[idx]==-1)
        {
            return null;
        }
        Node newNode=new Node(node[idx]);
        newNode.left=buildTree(node);
        newNode.right=buildTree(node);
        return newNode;

    }
}
