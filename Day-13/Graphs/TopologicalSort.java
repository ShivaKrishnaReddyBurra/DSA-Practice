import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src, dst;

        Edge(int src, int dst)
        {
            this.src = src;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visted[], Stack<Integer> stack)
    {

        visted[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);

            if(!visted[e.dst])
                topSort(graph, e.dst, visted, stack);
        }
        stack.push(curr);
    }    

    public static void main(String[] args) {
        int v = 6; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean visted[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < v; i++)
        {
            if(!visted[i])
                topSort(graph, i, visted, stack);
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        
        System.out.println();
        
    }
    
}
