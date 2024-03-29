import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int m, n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int i = b; i < d; i++) {
                for (int j = a; j < c; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if (arr[i][j] == 0) {
//                    dfs(i, j);
//                    result.add(count);
//                    count = 0;
//                }
                if (arr[i][j] == 0 && !visited[i][j])
                    result.add(bfs(i, j));
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(result.size() + "\n");
        for (int temp : result)
            sb.append(temp + " ");

        System.out.println(sb);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int i, int j) {
        arr[i][j] = -1;
        count++;

        for (int k = 0; k < 4; k++) {
            int tempX = i + dx[k];
            int tempY = j + dy[k];

            if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && arr[tempX][tempY] == 0) {
                dfs(tempX, tempY);
            }
        }
    }

    static int bfs(int i, int j) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(i, j));
        visited[i][j] = true;
        int count = 0;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();
            count++;

            for (int k = 0; k < 4; k++) {
                int tempX = poll.x + dx[k];
                int tempY = poll.y + dy[k];

                if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && !visited[tempX][tempY] && arr[tempX][tempY] == 0) {
                    visited[tempX][tempY] = true;
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