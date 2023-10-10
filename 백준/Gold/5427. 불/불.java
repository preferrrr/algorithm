import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 상근이는 벽을 통과할 수 없고,
        // 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다.
        // 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] arr = new char[h][w];
            int[][] visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                Arrays.fill(visited[i], -1);
            }

            Deque<Node> fires = new ArrayDeque<>();
            Node start = new Node();
            for (int i = 0; i < h; i++) {
                String temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = temp.charAt(j);
                    if (arr[i][j] == '*') {
                        fires.add(new Node(i, j));
                        visited[i][j] = 0;
                    } else if (arr[i][j] == '@') {
                        start.x = i;
                        start.y = j;
                    }
                }
            }

            fire(h, w, arr, fires, visited);
            int result = escape(h, w, arr, visited, start);

            if(result != -1)
                sb.append(result).append("\n");
            else
                sb.append("IMPOSSIBLE").append("\n");

        }

        System.out.print(sb);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node() {
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void fire(int h, int w, char[][] arr, Deque<Node> fires, int[][] visited) {
        while (!fires.isEmpty()) {
            Node poll = fires.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < h && y < w && visited[x][y] == -1 && arr[x][y] != '#') {
                    visited[x][y] = visited[poll.x][poll.y] + 1;
                    fires.add(new Node(x, y));
                }
            }
        }
    }

    static int escape(int h, int w, char[][] arr, int[][] dist, Node start) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[h][w];

        deque.add(start);
        dist[start.x][start.y] = 0;
        visited[start.x][start.y] = true;
        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < h && y < w && !visited[x][y] && arr[x][y] != '#' && (dist[x][y] > dist[poll.x][poll.y] + 1 || dist[x][y] == -1)) {
                    dist[x][y] = dist[poll.x][poll.y] + 1;
                    deque.addLast(new Node(x, y));
                } else if (x < 0 || y < 0 || x >= h || y >= w)
                    return dist[poll.x][poll.y] + 1;
            }
        }

        return -1;
    }
}