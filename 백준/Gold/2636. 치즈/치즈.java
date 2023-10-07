import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        int time = 0;
        int cheese = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    cheese++;
            }
        }


        while (true) {
            time++;
            int temp = bfs();

            if (cheese - temp == 0)
                break;
            else {
                cheese -= temp;
                for(int i = 0; i < n; i++) {
                    Arrays.fill(visited[i], false);
                }
            }

        }


        System.out.println(time + "\n" + cheese);


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

    static int bfs() {
        Deque<Node> deque = new ArrayDeque<>();

        deque.add(new Node(0, 0));
        visited[0][0] = true;

        List<Node> edge = new ArrayList<>();

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (rangeCheck(x, y)) {
                    if (arr[x][y] == 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        deque.add(new Node(x, y));
                    } else if (arr[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        edge.add(new Node(x, y));
                    }
                }
            }
        }

        edge.stream().forEach(node -> arr[node.x][node.y] = 0);

        return edge.size();
    }

    static boolean rangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static boolean allZero(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    return false;
            }
        }

        return true;
    }
}