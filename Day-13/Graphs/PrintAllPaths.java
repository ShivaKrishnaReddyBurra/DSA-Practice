import java.util.ArrayList;

public class PrintAllPaths {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void printAllPaths(ArrayList<Edge> graph[], boolean visted[], int curr, String path, int target)
    {
        if(target == curr)
        {
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!visted[e.dst])
            {
                visted[curr] = true;
                printAllPaths(graph, visted, e.dst, path + e.dst, target);
                visted[curr] = false;
            }
            
        }
    }
    public static void main(String[] args) {
        int v = 7; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        boolean visted[] = new boolean[v];
        
        int src = 0, target = 5;
        printAllPaths(graph, visted, src, "0", target);
        
        
        
    }
}
