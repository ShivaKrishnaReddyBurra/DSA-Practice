import java.util.ArrayList;
public class BellmanFord {
    static class Edge {
        int src, dst, wt;

        Edge(int src, int dst, int wt)
        {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    
    public static void bellmanFord(ArrayList<Edge> graph[], int src , int size)
    {
        int shortestDistance[] = new int[size];
        for(int i = 0; i < size; i++)
        {
            if(i != src)
                shortestDistance[i] = Integer.MAX_VALUE;
        }

        for(int k = 0; k < size -1; k++)
        {
            for(int i = 0; i < size; i++)
            {
                for(int j = 0; j < graph[i].size(); j++)
                {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dst;

                    if(shortestDistance[u] != Integer.MAX_VALUE && shortestDistance[u] + e.wt < shortestDistance[v])
                    {
                        shortestDistance[v] = shortestDistance[u] + e.wt;
                    }
                }
            }
        }

        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < graph[i].size(); j++)
            {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dst;

                if(shortestDistance[u] != Integer.MAX_VALUE && shortestDistance[u] + e.wt < shortestDistance[v])
                {
                    System.out.println("Negative weight cycle");
                }
            }
        }

        for(int i = 0; i < size; i++)
            System.out.print(shortestDistance[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int v = 5;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        bellmanFord(graph, 0, v);
    }
}
