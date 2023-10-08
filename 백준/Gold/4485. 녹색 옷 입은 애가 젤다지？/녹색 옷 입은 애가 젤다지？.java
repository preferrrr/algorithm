import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0)
                break;

            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(arr, dist, n) + arr[n - 1][n - 1];
            sb.append("Problem " + count + ": " + result).append("\n");
            count++;
        }

        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dijkstra(int[][] arr, int[][] dist, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, 0, arr[0][0]));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < n && y < n && dist[x][y] > dist[poll.x][poll.y] + poll.w) {
                    dist[x][y] = dist[poll.x][poll.y] + poll.w;
                    queue.add(new Node(x, y, arr[x][y]));
                }
            }
        }

        return dist[n - 1][n - 1];
    }


}