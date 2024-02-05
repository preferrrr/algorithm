import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int cheese = 0;
    static int time = 0;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(time + "\n" + cheese);
    }

    static void solve() {
        while (bfs()) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        }
    }

    static boolean bfs() {

        List<Node> cheeses = new ArrayList<>();

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y]) {
                    if (arr[x][y] == 0) {
                        deque.addLast(new Node(x, y));
                    } else {
                        cheeses.add(new Node(x, y));
                    }
                    visited[x][y] = true;
                }
            }
        }

        if (cheeses.isEmpty()) {
            return false;
        } else {
            time++;
            cheese = cheeses.size();

            for (int i = 0; i < cheeses.size(); i++) {
                Node node = cheeses.get(i);
                arr[node.x][node.y] = 0;
            }
            return true;
        }
    }

    static boolean allMelt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
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



