import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] items;

    static Map<Integer, ArrayList<Node>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        int max = -1;

        for(int i = 1; i <= n; i++) {
            int itemCount = dijkstraAndItemCount(i);
            max = Math.max(itemCount, max);
        }

        System.out.println(max);


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

    //다익스트라 알고리즘으로 시작 노드에서 모든 노드로 가는 최단 거리를 구하고,
    //최단 거리가 수색 범위 이하인 곳의 item 개수를 모두 더함.
    static int dijkstraAndItemCount(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            List<Node> linked = graph.get(poll.v);

            for(Node node : linked) {
                if(dist[node.v] > dist[poll.v] + node.w) {
                    dist[node.v] = dist[poll.v] + node.w;
                    queue.add(new Node(node.v, dist[node.v]));
                }
            }
        }

        int itemCount = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] <= m) {
                itemCount += items[i];
            }
        }

        return itemCount;

    }
}