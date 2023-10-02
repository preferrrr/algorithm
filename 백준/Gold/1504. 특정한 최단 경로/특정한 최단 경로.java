import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Node>> graph = new HashMap<>();
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, n);

        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, n);

        if(result1 >= INF && result2 >= INF)
            System.out.println(-1);
        else if(result1 > result2)
            System.out.println(result2);
        else
            System.out.println(result1);


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

    static int dijkstra(int a, int b) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(a, 0));
        dist[a] = 0;


        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.v == b)
                break;
            if (visited[poll.v])
                continue;

            visited[poll.v] = true;

            List<Node> linked = graph.get(poll.v);

            for (Node node : linked) {
                if (dist[node.v] > dist[poll.v] + node.w) {
                    dist[node.v] = dist[poll.v] + node.w;
                    queue.add(new Node(node.v, dist[node.v]));
                }
            }
        }

        return dist[b];

    }
}