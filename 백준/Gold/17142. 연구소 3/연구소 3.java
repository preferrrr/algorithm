import java.io.*;
import java.util.*;

public class Main {
    static int n, m, zeroCount = 0, result = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visitedVirus;

    static List<Node> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2)
                    virus.add(new Node(i, j, 0));
                else if(arr[i][j] == 0)
                    zeroCount++;
            }
        }

        visitedVirus = new boolean[virus.size()];

        dfs(-1, 0);

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);


    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static void dfs(int cur, int count) {
        if (count == m) {
            bfs();
            return;
        }

        for (int i = cur + 1; i < virus.size(); i++) {
            if (!visitedVirus[i]) {
                visitedVirus[i] = true;
                dfs(i, count + 1);
                visitedVirus[i] = false;
            }
        }

    }

    static void bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < virus.size(); i++) {
            if (visitedVirus[i]) {
                Node node = virus.get(i);
                deque.add(node);
                visited[node.x][node.y] = true;
            }
        }

        int zero = 0;
        int max = 0;

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            if(poll.d > max && arr[poll.x][poll.y] == 0)
                max = poll.d;

            for(int d = 0; d < 4; d++) {
                int x = poll.x + dx[d];
                int y = poll.y + dy[d];

                if(x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && (arr[x][y] == 0 || arr[x][y] == 2)) {
                    deque.add(new Node(x, y, poll.d + 1));
                    visited[x][y] = true;

                    if(arr[x][y] == 0)
                        zero++;
                }
            }
        }

        if(zero == zeroCount && result > max)
            result = max;
    }
}