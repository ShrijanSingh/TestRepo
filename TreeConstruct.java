import java.util.*;
public class TreeConstruct {
    // static int lh;
    // static int rh;
    // static int lc,rc;
    // static int totalC;
    public static class Info{
        int diam;
        int height;
        Info(int diam,int height)
        {
            this.diam=diam;
            this.height=height;
        }
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1)
                return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root) {

            if (root == null)
                return;
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);

        }
        public static void inorder (Node root)
        {
            if (root==null)
            return;
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }  
        public static void postorder(Node root)
        {
            if (root==null)
            return ;
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
        public static void levelorder(Node root)
        {
    if (root ==null)
    {
        return;
    }
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty())
    {
        Node currNode=q.remove();
        if (currNode==null){
        
            System.out.println();
        
        if (q.isEmpty())
        {
            break;
        }
        else 
        q.add(null);
    }
    else{
        System.out.print(currNode.data);
        if (currNode.left!=null)
        q.add(currNode.left);
        if (currNode.right!=null)
        q.add(currNode.right);
    }
}
}
        public static int heightOfTree(Node root)
        {
            if (root==null)
            return 0;
            int lh=heightOfTree(root.left);
            int rh=heightOfTree(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int countOfNode(Node root)
        {
            if (root==null)
            return 0;
           int  lc=countOfNode(root.left);
            int rc=countOfNode(root.right);
            int totalC=lc+rc+1;
            return totalC;
        }
        public static int sumOfNodes(Node root)
        {
            if (root==null)
            {
                return 0;
            }
            int ls=sumOfNodes(root.left);
            int rs=sumOfNodes(root.right);
            int treeSum=ls+rs+root.data;
            return treeSum;
        }
        public static int diameterOfTree1(Node root)
        {
            if (root==null)
            return 0;
            int ld=diameterOfTree1(root.left);
            int lh=heightOfTree(root.left);
            int rd=diameterOfTree1(root.right);
            int rh=heightOfTree(root.right);
            int selfDiam=lh+rh+1;
            return Math.max(Math.max(ld,rd),selfDiam);
        }
        public static Info diameterOfTree2(Node root)
        {
            if (root==null)
            return new Info(0,0);
            Info leftInfo=diameterOfTree2(root.left);
            Info rightInfo=diameterOfTree2(root.right);
            int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.height+rightInfo.height+1);
            int ht=Math.max(leftInfo.height,rightInfo.height)+1;
            return new Info(diam, ht);
        }
        public static void kthLevel(Node root, int k, int level)
        {
            if (root==null)
            return;
            if (level==k)
            {
                System.out.println(root.data);
            }
            kthLevel(root.left, k, level+1);
            kthLevel(root.right, k, level+1);
        }
        public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            // BinaryTree tree=new BinaryTree();
            Node root = BinaryTree.buildTree(nodes);
            System.out.println(root.data);
            System.out.println("Preorder Traversal");
            BinaryTree.preorder(root);
            System.out.println("Inorder Traversal");
            BinaryTree.inorder(root);
            System.out.println("Postorder Traversal");
            BinaryTree.postorder(root);
            System.out.println("Level order Traversal");
            BinaryTree.levelorder(root);
            System.out.print("Height of the Tree= ");
           System.out.println( BinaryTree.heightOfTree(root));
           System.out.println("No of Nodes= "+BinaryTree.countOfNode(root));
           System.out.println("Sum of Nodes Of Tree= "+ BinaryTree.sumOfNodes(root));
           System.out.println("Diameter of Tree1= "+ BinaryTree.diameterOfTree1(root));
           System.out.println("Diameter of Tree2= "+BinaryTree.diameterOfTree2(root).diam);
           System.out.println("2"+"th level printing of node");
           kthLevel(root, 3, 1);
        }
    }
}

