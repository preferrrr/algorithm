import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int arr[][];
    static int n, m;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(x, y, d);

        System.out.println(count);


    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static void dfs(int i, int j, int dir) {

        if (arr[i][j] == 0 && !visited[i][j]) {
            count++;
            visited[i][j] = true;
        }

        boolean flag = false;
        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];

            if(x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == 0 && !visited[x][y])
                flag = true;
        }

        if(flag) {
            int nextD = dir - 1;
            if (nextD == -1)
                nextD = 3;

            int x = i + dx[nextD];
            int y = j + dy[nextD];

            if (x >= 0 && y >= 0 && x < n && y < m && arr[x][y] == 0 && !visited[x][y])
                dfs(x, y, nextD);
            else {
                dfs(i, j, nextD);
            }
        }
        else {
            int x = i - dx[dir];
            int y = j - dy[dir];

            if (x >= 0 && y >= 0 && x < n && y < m) {
                if(arr[x][y] == 0)
                    dfs(x, y, dir);
                else return;
            }
        }
    }
}