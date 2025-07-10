import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTreeImpl {

    static int index = -1;

    public Node buildBinaryTree(int nodes[])
    {
        index++;
        if(nodes[index] == -1)
        {
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = buildBinaryTree(nodes);
        newNode.right = buildBinaryTree(nodes);

        return newNode;
    }

    public void perorderTraversal(Node root)
    {
        if(root == null)
        {
            // System.out.print(-1+ " ");
            return;
        }
        System.out.print(root.data + " ");
        perorderTraversal(root.left);
        perorderTraversal(root.right);
    }

    public void inorderTraversal(Node root)
    {
        if(root == null)
        {
            // System.out.print(-1+ " ");
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public void postorderTraversal(Node root)
    {
        if(root == null)
        {
            // System.out.print(-1+ " ");
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void levelorderTraversal(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) 
        {
            Node currNode = q.remove();
            if(currNode == null)
            {
                System.out.println();
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }    
            else
            {
                System.out.print(currNode.data + " ");
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }
    
    public int countOfNodes(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes +1;
    }

    public int sumOfNodes(Node root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;

    }

    public int height(Node root)
    {
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class BinaryTree {
    
    public static void main(String[] args) {
        int nodes[] = {1,2,3,-1,-1,5,-1,-1,4,-1,6,-1,-1};
        BinaryTreeImpl tree = new BinaryTreeImpl();

        Node root = tree.buildBinaryTree(nodes);
        // System.out.println(root.left.data);

        tree.perorderTraversal(root);
        System.out.println();
        tree.inorderTraversal(root);
        System.out.println();
        tree.postorderTraversal(root);
        System.out.println();
        tree.levelorderTraversal(root);
        int totalNodes = tree.countOfNodes(root);
        System.out.println("Total Number of Nodes: " + totalNodes);
        int sumOfNodes = tree.sumOfNodes(root);
        System.out.println("Sum of Nodes:" + sumOfNodes);
        int height = tree.height(root);
        System.out.println("height of the tree: " + height);
    }
}
