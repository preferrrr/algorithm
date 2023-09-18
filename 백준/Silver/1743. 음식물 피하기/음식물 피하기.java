import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a - 1][b - 1] = 1;
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    int temp = bfs(i, j);
                    if (temp > max)
                        max = temp;
                }
            }
        }

        System.out.println(max);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs(int i, int j) {
        int count = 0;
        Deque<Node> deque = new ArrayDeque<>();
        arr[i][j] = -1;
        deque.add(new Node(i, j));

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();
            count++;

            for (int d = 0; d < 4; d++) {
                int tempX = poll.x + dx[d];
                int tempY = poll.y + dy[d];

                if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m && arr[tempX][tempY] == 1) {
                    arr[tempX][tempY] = -1;
                    deque.add(new Node(tempX, tempY));
                }
            }
        }

        return count;

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}