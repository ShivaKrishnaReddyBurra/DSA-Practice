import java.util.ArrayList;

public class DFS {
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

    public static void dsf(ArrayList<Edge> graph[], boolean visted[], int curr)
    {
        System.out.print(curr + " ");
        visted[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);

            if(visted[e.dst] == false)
                dsf(graph, visted, e.dst);
        }
    }
    public static void main(String[] args) {
        int v = 7; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        boolean visted[] = new boolean[v];
        
        for(int i = 0; i < v; i++)
        {
            if(visted[i] == false)
                dsf(graph, visted, i);
        }
        
        System.out.println();
        
        
    }
}
