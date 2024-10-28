import java.util.*;
public class BST {
    public static class Node
        {
            int data;
            Node left;
            Node right;
            Node(int val)
            {
                data=val;
            }
        }
        //Insert in BST
        public static Node insert(Node root,int val)
        {
            if (root==null)
            {
                root=new Node(val);
                return root;
            }
            if (root.data>val)
            {
                root.left=insert(root.left,val);

            }
            else 
            root.right=insert(root.right, val);
            return root;
        }
        //In-Order Traversal of BST
        public static void inorder(Node root)
        {
            if (root==null)
            return;
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
            
        }
        //Search in BST
        public static boolean Search(Node root,int key)
        {
            if (root==null)
            return false;
            if (root.data==key)
            return true;
            if (root.data>key){
            return Search(root.left,key);
            }
            else {
            return Search(root.right,key);
        }
        }
        //Delete a Node in BST
        public static Node delNode(Node root,int val)
        {
            if (root==null)
            return null;
            if (root.data<val)
            root.right=delNode(root.left, val);
            else if (root.data>val)
            root.left=delNode(root.right, val);
            //Element Node Found
            else 
            {
                System.out.println("Deleted Node=" + root.data);
                //Case 1 when no node available
                if (root.left == null && root.right==null)
                return null;
                else if (root.left==null)
                return root.right;
                else if (root.right==null)
                return root.left;
                else {
                Node IS=inorderSucccessor(root.right);
                root.data=IS.data;
                root.right=delNode(root.right, IS.data);
            }
        }
        return root;
    }
        //Inorder Successor
        public static Node inorderSucccessor(Node root)
        {
            while (root.left!=null && root.left!=null)
            {
                root=root.left;
            }
            return root;
        }
        //Print In Range
        public static void printInRange(Node root, int K1,int K2)
        {
            if (root==null)
            return;
            if (root.data>=K1 && root.data<=K2)
            {
                printInRange(root.left,K1,K2);
                System.out.println(root.data+" ");
                printInRange(root.right,K1,K2);
            }
        else if (root.data<K1)
        {
            printInRange(root.right,K1,K2);
        }
        else
        printInRange(root.left,K1,K2);
        }
        //Leaf to Path
        public static void leafPath(Node root, ArrayList<Integer> ar)
        {
            if (root ==null)
            {
                return;
            }
            ar.add(root.data);
            if (root.left==null && root.right==null)
            {
                printPath(ar);
            }
            else{
            leafPath(root.left, ar);
            leafPath(root.right, ar);
        }
            ar.remove(ar.size()-1);
        }
        public static void printPath(ArrayList<Integer> ar)
        {
            for (int i=0;i<ar.size();i++)
            {
                System.out.print(ar.get(i)+"->");
            }
            
            System.out.print("Null");
            System.out.println();
        }
    



        public static void main(String[] args) {
        int value[]={8,5,3,6,10,11,14};
        Node root=null;
        for (int i=0;i<value.length;i++)
        {
            root=insert(root,value[i]);
        }
        
        //Inorder Traversal Of BST
        System.out.println("Inorder Traversal of BST");
        inorder(root);
        System.out.println();
        // Searching in BST
        int key=3;
        if (Search(root, key))
        {
        System.out.println("Searched element is found");
        }
        else{
        System.out.println("Searched element not found");
    }
    // //Delete Node From BST
    //    root= delNode(root, 5);
    // //After Deletion;
    // System.out.println("BST after deletion");
    // inorder(root);
    // System.out.println();
    // //Print In Range
    // printInRange(root, 3, 4);
    // //Print path to LeafNode
    System.out.println("Print path to leaf Node");
    leafPath(root, new ArrayList<>());
}
}