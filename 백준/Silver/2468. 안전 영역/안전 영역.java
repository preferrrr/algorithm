import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
        }

        int result = 0;

        for (int k = 0; k <= max; k++) {

            int count = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > k && !visited[i][j]) {
                        count++;
                        dfs(i, j, k);
                    }
                }
            }

            if (count > result)
                result = count;

        }

        System.out.println(result);


    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int k) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n
                    && arr[tempX][tempY] > k
                    && !visited[tempX][tempY])
                dfs(tempX, tempY, k);
        }

    }
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y, int k) {
        Deque<Node> deque = new ArrayDeque();
        deque.add(new Node(x,y));
        visited[x][y] = true;

        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int tempX = x + dx[i];
                int tempY = y + dy[i];

                if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n
                        && arr[tempX][tempY] > k
                        && !visited[tempX][tempY]) {
                    visited[tempX][tempY] = true;
                    deque.add(new Node(tempX, tempY));
                }
            }
        }
    }
}