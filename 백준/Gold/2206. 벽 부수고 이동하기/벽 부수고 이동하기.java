import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp.charAt(j) - 48;
            }
        }

        bfs();

        if(result != Integer.MAX_VALUE)
            System.out.println(result);
        else System.out.println(-1);


    }

    static class Node implements Comparable<Node> {
        int x, y, w;
        int wall; // false일 때가 벽을 부수지 않은 상태.

        public Node(int x, int y, int w, int wall) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.wall = wall;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = Integer.MAX_VALUE;

    static void bfs() {
        Deque<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][2];
        //벽을 부순 상태로 왔을 때와 부수지 않은 상태로 왔을 때가 다르므로 구분해야 함.

        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;
        //0 == false
        //1 == true

        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();

            if (cur.x == n - 1 && cur.y == m - 1) {
                if (result > cur.w)
                    result = cur.w;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                //다음 칸이 0이고 현재 부순 벽 0 : 거리 + 1로 갱신, wall 그대로
                //다음 칸이 0이고 현재 부순 벽 1 : 거리 + 1로 갱신, wall 그대로
                //다음 칸이 1이고 현재 부순 벽 0 : 거리 + 1로 갱신, wall = true
                //다음 칸이 1이고 현재 부순 벽 1 : 못감.
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (arr[x][y] == 0 && !visited[x][y][cur.wall]) {
                        if(cur.wall == 0)
                            visited[x][y][0] = true;
                        else visited[x][y][1] = true;

                        queue.add(new Node(x, y, cur.w + 1, cur.wall));
                    } else if (arr[x][y] == 1 && cur.wall == 0) {
                        visited[x][y][1] = true;
                        queue.add(new Node(x, y, cur.w + 1, 1));
                    }
                }
            }
        }
    }
}