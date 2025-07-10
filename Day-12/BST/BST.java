import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BST {

    public static Node createBST(int val, Node root)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        if(root.val > val)
            root.left = createBST(val, root.left);
        else
            root.right = createBST(val, root.right);
        
        return root;
    }

    public static void inorderTraversal(Node root)
    {
        if(root == null)
            return;
        
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static boolean search(Node root, int key)
    {
        if(root == null)
            return false;

        if(root.val == key)
            return true;
        else if(root.val > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static Node delete(Node root, int val)
    {
        if(root.val > val)
            root.left = delete(root.left, val);
        else if(root.val < val)
            root.right = delete(root.left, val);
        else
        {
            //leaf node
            if(root.left == null && root.right == null)
                return null;
            
            //has one child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            //has two childs
            Node inorderSuccessorNode = inorderSuccessor(root.right);
            root.val = inorderSuccessorNode.val;
            root.right = delete(root.right, inorderSuccessorNode.val);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root)
    {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y)
    {
        if(root == null)
            return;
        
        if(root.val >= x && root.val <= y)
        {
            printInRange(root.left, x, y);
            System.out.print(root.val + " ");
            printInRange(root.right, x, y);
        }
        else if(root.val >= x)
            printInRange(root.right, x, y);
        else
            printInRange(root.left, x, y);
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path)
    {
        if(root == null)
            return;

        path.add(root.val);

        if(root.left == null && root.right == null) //leaf node
            printPath(path);
        else
        {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path)
    {
        for(int i = 0; i < path.size(); i++ )
            System.out.print(path.get(i) + "-->");
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,1,3,4,2,7};
        Node root = null;

        for(int i = 0; i < arr.length; i++)
            root = createBST(arr[i],root);
        
        inorderTraversal(root);
        System.out.println();

        if(search(root, 5))
            System.out.println("Element found");
        else
            System.out.println("Element not found");

        delete(root, 1);
        inorderTraversal(root);
        System.out.println();
        printInRange(root, 3, 5);
        System.out.println();
        printRoot2Leaf(root, new ArrayList<Integer>());

    }
    
}
