import java.util.ArrayList;

public class CycleDetection {
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

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visted[], int curr, boolean rec[])
    {
        visted[curr] = true;
        rec[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);

            if(rec[e.dst])
                return true;
            
            if(!visted[e.dst])
            {
                if(isCycleDirected(graph, visted, e.dst, rec))
                    return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 7; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean visted[] = new boolean[v];
        boolean rec[] = new boolean[v];

        for(int i = 0; i < v; i++)
        {
            if(!visted[i])
            {
                boolean isCycle = isCycleDirected(graph, visted, i, rec);
                if(isCycle)
                {
                    System.out.println(isCycle);
                    break;
                }
            }
        }
        
    }
}
