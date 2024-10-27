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
        public 

        public static void main(String[] args) {
        int value[]={5,1,3,4,2,7};
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
}

}