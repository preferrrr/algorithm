import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, d;
    static int[][] arr;
    static boolean[] archer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m];
        archer = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(-1, 0);

        System.out.println(result);
    }

    static void dfs(int pos, int count) {
        if (count == 3) {
            temp = 0;
            int[][] copy = new int[n + 1][m];
            for (int i = 0; i < n + 1; i++) {
                copy[i] = arr[i].clone();
            }

            while (!allZero(copy)) {
                defend(copy);
                move(copy);
            }

            if (temp > result)
                result = temp;
            return;
        }

        for (int i = pos + 1; i < m; i++) {
            if (!archer[i]) {
                archer[i] = true;
                dfs(i, count + 1);
                archer[i] = false;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d == o.d)
                return this.y - o.y;
            return this.d - o.d;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int temp = 0, result = 0;

    static void defend(int[][] copy) {



        List<Node> kill = new ArrayList<>();

        for (int a = 0; a < m; a++) {
            if (archer[a]) {
                Deque<Node> deque = new ArrayDeque<>();
                boolean[][] visited = new boolean[n + 1][m];
                PriorityQueue<Node> queue = new PriorityQueue<>();

                deque.add(new Node(n, a, 0));
                visited[n][a] = true;

                while (!deque.isEmpty()) {
                    Node poll = deque.pollFirst();

                    for (int i = 0; i < 4; i++) {
                        int x = poll.x + dx[i];
                        int y = poll.y + dy[i];

                        if (x > 0 && y >= 0 && x < n && y < m) {
                            if (copy[x][y] == 0 && poll.d + 1 < d && !visited[x][y]) {
                                visited[x][y] = true;
                                deque.add(new Node(x, y, poll.d + 1));
                            } else if (copy[x][y] == 1 && poll.d + 1 <= d && !visited[x][y]) {
                                visited[x][y] = true;
                                queue.add(new Node(x, y, poll.d + 1));

                            }
                        }
                    }
                }

                boolean flag = false;

                if(queue.isEmpty())
                    continue;
                Node minDistEnemy = queue.poll();

                for (int i = 0; i < kill.size(); i++) {
                    Node enemy = kill.get(i);

                    if (enemy.x == minDistEnemy.x && enemy.y == minDistEnemy.y)
                        flag = true;

                }

                if (!flag)
                    kill.add(minDistEnemy);
            }
        }


        for (int i = 0; i < kill.size(); i++) {
            Node enemy = kill.get(i);
            copy[enemy.x][enemy.y] = 0;
            temp++;
        }

    }

    static void move(int[][] copy) {
        for (int j = 0; j < m; j++) {
            copy[n - 1][j] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (copy[i][j] == 1) {
                    copy[i + 1][j] = 1;
                    copy[i][j] = 0;
                }
            }
        }
    }

    static boolean allZero(int[][] arr) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    return false;
            }
        }

        return true;
    }
}