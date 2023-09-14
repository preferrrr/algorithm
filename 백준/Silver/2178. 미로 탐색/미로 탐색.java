import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = temp.charAt(j) - 48;
            }
        }

        bfs(0,0);

        System.out.println(maze[n-1][m-1]);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int y, int x) {
        Node start = new Node(x, y);

        Deque<Node> deque = new ArrayDeque<>();

        deque.add(start);

        while (!deque.isEmpty()) {
            Node node = deque.poll();

            if(node.x == m - 1 && node.y == n-1)
                break;

            for (int i = 0; i < 4; i++) {
                int tempX = node.x + dx[i];
                int tempY = node.y + dy[i];
                if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && maze[tempY][tempX] == 1) {
                    maze[tempY][tempX] = maze[node.y][node.x] + 1;
                    deque.add(new Node(tempX, tempY));
                }
            }

        }


    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}