import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);


    }
    //벽 3개 세우고, 바이러스 퍼트리고, 안전영역 개수 센다.
    //벽 3개 세우는 모든 경우를 다 체크해야함.

    static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(count + 1);
                    arr[i][j] = 0;
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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs() {
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2)
                    deque.add(new Node(i, j));
            }
        }

        int[][] copyArr = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }

        while (!deque.isEmpty()) {
            Node poll = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int tempX = poll.x + dx[i];
                int tempY = poll.y + dy[i];

                if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < m && copyArr[tempX][tempY] == 0) {
                    copyArr[tempX][tempY] = 2;
                    deque.add(new Node(tempX, tempY));
                }
            }

        }

        safeZone(copyArr);

    }

    static void safeZone(int[][] arr) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0)
                    count++;
            }
        }
        if(count > result)
            result = count;
    }


}