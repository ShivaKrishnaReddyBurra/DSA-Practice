import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlg {
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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {

        int node, distance;

        Pair(int node, int distance)
        {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.distance - p2.distance;
        }
    }

    public static void dijkstraAlg(ArrayList<Edge> graph[], int src, int size)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int shortestDistance[] = new int[size];
        boolean visted[] = new boolean[size];
        for(int i = 0; i< size; i++)
        {
            if(i != src)
            {
                shortestDistance[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            visted[curr.node] = true;

            for(int i = 0; i < graph[curr.node].size(); i++)
            {
                Edge e = graph[curr.node].get(i);

                int u = e.src;
                int v = e.dst;

                if(shortestDistance[u] + e.wt < shortestDistance[v])
                {
                    shortestDistance[v] = shortestDistance[u] + e.wt;
                    pq.add(new Pair(v, shortestDistance[v]));
                }
            }
        }

        for(int i = 0; i < size; i++)
            System.out.print(shortestDistance[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int v = 6;

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        dijkstraAlg(graph, 0, v);


    }
}
