import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, List<Node>> map = new HashMap<>();
    static int n, m, start, end;
    static int[] dist;
    static boolean[] visited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node> {
        int x, w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        for(int i = 0 ; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if(visited[poll.x])
                continue;

            visited[poll.x] = true;

            for (Node node : map.get(poll.x)) {
                if(dist[node.x] > dist[poll.x] + node.w) {
                    dist[node.x] = dist[poll.x] + node.w;
                    queue.add(new Node(node.x, dist[node.x]));
                }
            }
        }
    }




}