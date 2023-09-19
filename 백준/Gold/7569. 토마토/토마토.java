import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int h;
    static int[][][] arr;

    static Deque<Node> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1)
                        deque.add(new Node(i, j, k));
                }
            }
        }

        bfs();

        System.out.println(findResult(arr));

    }

    static int[] dx = {0, 0, -1, 0, 1, 0}; // 위, 아래, 북 동 남 서
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    static int findResult(int[][][] arr) {
        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[k][i][j] == 0)
                        return -1;
                    else if(arr[k][i][j] > max)
                        max = arr[k][i][j];
                }
            }
        }

        return max - 1;
    }

    static void bfs() {
        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int d = 0; d < 6; d++) {
                int tempX = poll.x + dx[d];
                int tempY = poll.y + dy[d];
                int tempZ = poll.z + dz[d];

                if (check(tempX, tempY, tempZ)) {
                    arr[tempZ][tempX][tempY] = arr[poll.z][poll.x][poll.y] + 1;
                    deque.addLast(new Node(tempX, tempY, tempZ));
                }
            }
        }
    }

    static boolean check(int x, int y, int z) {
        return x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < h && arr[z][x][y] == 0;
    }

    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}