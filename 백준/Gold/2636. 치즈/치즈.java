import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, time;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        int cheese = solve();
        System.out.println(time + "\n" + cheese);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();

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
                        list.add(new Node(x, y));
                    }
                    visited[x][y] = true;
                }
            }
        }

        for(int i = 0 ; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        if(list.isEmpty()) {
            return 0;
        } else {
            for(int i = 0 ; i < list.size(); i++) {
                arr[list.get(i).x][list.get(i).y] = 0;
            }
            return list.size();
        }
    }

    static int solve() {

        int cheese = 0;
        while(true) {
            int temp = bfs();
            if(temp == 0)
                break;
            else {
                time++;
                cheese = temp;
            }
        }

        return cheese;
    }
}