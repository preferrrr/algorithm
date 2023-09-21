import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dist;
    static boolean[] visited;

    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(start, end);

        System.out.println(dist[end]);

    }

    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            if (this.w == o.w) {
                return (Math.abs(end - this.v)) - (Math.abs(end - o.v));
            }
            return this.w - o.w;
        }
    }

    static boolean rangeCheck(int v) {
        return v >= 0 && v < 100001;
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll.v == end)
                break;

            if (visited[poll.v])
                continue;

            visited[poll.v] = true;

            if (rangeCheck(poll.v - 1) && dist[poll.v - 1] > dist[poll.v] + 1) {
                dist[poll.v - 1] = dist[poll.v] + 1;
                queue.add(new Node(poll.v - 1, dist[poll.v - 1]));
            }
            if (rangeCheck(poll.v + 1) && dist[poll.v + 1] > dist[poll.v] + 1) {
                dist[poll.v + 1] = dist[poll.v] + 1;
                queue.add(new Node(poll.v + 1, dist[poll.v + 1]));
            }
            if(rangeCheck(poll.v * 2) && dist[poll.v * 2] > dist[poll.v]) {
                dist[poll.v * 2] = dist[poll.v];
                queue.add(new Node(poll.v * 2, dist[poll.v * 2]));
            }
        }
    }
}