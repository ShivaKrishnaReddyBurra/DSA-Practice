import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
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
    }

    public static void bsf(ArrayList<Edge> graph[], boolean visted[], int start)
    {
        Queue<Integer> q = new LinkedList<>();
      
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(visted[curr] == false)
            {
                System.out.print(curr + " ");
                visted[curr] = true;

                for(int i = 0; i< graph[curr].size(); i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 7; // vertices

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        boolean visted[] = new boolean[v];

        for(int i = 0; i < v; i++) // works with disconnect edges also
        {
            if(visted[i] == false)
                bsf(graph, visted, i);  
        }
        System.out.println();
        
        
    }
}
