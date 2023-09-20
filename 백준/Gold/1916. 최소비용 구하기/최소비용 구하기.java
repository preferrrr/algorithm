import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Node>> graph = new HashMap<>();
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, price));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

    }

    static class Node implements Comparable<Node> {
        int city, cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(visited[poll.city])
                continue;

            visited[poll.city] = true;

            for(Node node : graph.get(poll.city)) {
                if(dist[node.city] > dist[poll.city] + node.cost) {
                    dist[node.city] = dist[poll.city] + node.cost;
                    queue.add(new Node(node.city, dist[node.city]));
                }
            }

        }


    }
}