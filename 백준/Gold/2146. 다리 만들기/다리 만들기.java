import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 네 방향 중 하나라도 0이면 BFS 탐색

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int num = 2; // 섬끼리 구분.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    changeNum(i, j, num);
                    num++;
                }
            }
        }

        int result = Integer.MAX_VALUE;

        // 섬의 모서리에서 탐색을 시작해서,
        // 다른 섬을 만날 때까지의 최소 거리들을 모두 구하고 그 중 최소값.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0 && isEdge(i, j)) {
                    int temp = bfs(i, j, arr[i][j]);
                    if(result > temp) {
                        result = temp;
                    }
                }
            }
        }

        System.out.println(result);


    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean isEdge(int i, int j) {

        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];

            if (x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == 0)
                return true;
        }

        return false;
    }

    static void changeNum(int i, int j, int num) {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        deque.add(new Node(i, j));
        visited[i][j] = true;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();
            arr[poll.x][poll.y] = num;

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && arr[x][y] != 0) {
                    visited[x][y] = true;
                    deque.addLast(new Node(x, y));
                }
            }
        }
    }

    static int bfs(int i, int j, int num) {

        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        deque.add(new Node(i, j));
        visited[i][j] = true;
        dist[i][j] = 0;

        int result = 100001;
        while (!deque.isEmpty()) {

            Node poll = deque.pollFirst();

            if(arr[poll.x][poll.y] != 0 && arr[poll.x][poll.y] != num) {
                result = dist[poll.x][poll.y] - 1;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && (arr[x][y] == 0 || arr[x][y] != num)) {

                    visited[x][y] = true;
                    dist[x][y] = dist[poll.x][poll.y] + 1;
                    deque.addLast(new Node(x, y));

                }
            }
        }

        return result;

    }
}