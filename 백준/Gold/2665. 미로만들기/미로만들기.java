import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static int[][] maze;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j) - 48;
            }
        }

        dijkstra();

        System.out.println(dist[n-1][n-1]);


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

    static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (maze[x][y] == 0 && dist[x][y] > poll.w + 1) {
                        dist[x][y] = poll.w + 1;
                        queue.add(new Node(x, y, dist[x][y]));
                    } else if(maze[x][y] == 1 && dist[x][y] > poll.w) {
                        dist[x][y] = poll.w;
                        queue.add(new Node(x, y, dist[x][y]));
                    }
                }
            }
        }
    }
}