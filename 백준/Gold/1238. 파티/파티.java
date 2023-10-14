import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, ArrayList<Node>> graph1 = new HashMap<>();
        Map<Integer, ArrayList<Node>> graph2 = new HashMap<>();

        int[] dist1, dist2;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist1 = new int[n + 1];
        dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            graph1.put(i, new ArrayList<>());
            graph2.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph1.get(a).add(new Node(b, w));
            graph2.get(b).add(new Node(a, w));
        }

        dijkstra(graph1, dist1, x);
        dijkstra(graph2, dist2, x);

        int result = 0;

        for(int i = 1 ; i <= n; i++) {
            if(dist1[i] + dist2[i] > result) {
                result = dist1[i] + dist2[i];
            }
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static void dijkstra(Map<Integer, ArrayList<Node>> graph, int[] dist,int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            List<Node> list = graph.get(poll.v);

            for (Node node : list) {
                if (dist[node.v] > dist[poll.v] + node.w) {
                    dist[node.v] = dist[poll.v] + node.w;
                    queue.add(new Node(node.v, dist[node.v]));
                }
            }
        }

    }
}