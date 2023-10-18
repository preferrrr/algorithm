import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, start, end;
    static int[] arr, dist, before;
    static Map<Integer, ArrayList<Node>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dist = new int[n + 1];
        before = new int[n + 1];
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());
        Arrays.fill(dist, Integer.MAX_VALUE);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        sb.append(dist[end]).append("\n");

        int count = 1;

        StringBuilder path = new StringBuilder();
        path.append(end+" ");

        while (start != end) {
            count++;
            end = before[end];
            path.insert(0,end + " ");
        }

        sb.append(count + "\n");
        sb.append(path);
        System.out.println(sb);

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

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if(visited[poll.v])
                continue;

            visited[poll.v] = true;

            List<Node> linked = graph.get(poll.v);

            for (Node node : linked) {
                if (dist[node.v] > dist[poll.v] + node.w) {
                    dist[node.v] = dist[poll.v] + node.w;
                    before[node.v] = poll.v;
                    queue.add(new Node(node.v, dist[node.v]));
                }
            }
        }
    }
}