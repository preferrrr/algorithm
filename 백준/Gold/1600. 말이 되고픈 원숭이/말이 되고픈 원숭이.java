import java.io.*;
import java.util.*;

public class Main {
    static int w, h, k;
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        System.out.println(result);


    }

    static class Node {
        int x, y, k, w;

        public Node(int x, int y, int k, int w) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.w = w;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] dx2 = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy2 = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int bfs() {
        Deque<Node> deque = new ArrayDeque<>();

        deque.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            if (poll.x == h - 1 && poll.y == w - 1)
                return poll.w;

                for (int d = 0; d < 4; d++) {
                    int x = poll.x + dx[d];
                    int y = poll.y + dy[d];

                    if (x >= 0 && y >= 0 && x < h && y < w && arr[x][y] == 0) {
                        if (!visited[x][y][poll.k]) {
                            visited[x][y][poll.k] = true;
                            deque.add(new Node(x, y, poll.k, poll.w + 1));
                        }
                    }
                }

            for (int d = 0; d < 8; d++) {
                int x = poll.x + dx2[d];
                int y = poll.y + dy2[d];

                if (x >= 0 && y >= 0 && x < h && y < w && arr[x][y] == 0) {
                    if (poll.k < k && !visited[x][y][poll.k + 1]) {
                        visited[x][y][poll.k + 1] = true;
                        deque.add(new Node(x, y, poll.k + 1, poll.w + 1));
                    }
                }

            }
        }

        return -1;
    }
}