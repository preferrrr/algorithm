import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new int[m][n];

        for(int i = 0 ; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,0));

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dfs(int x, int y) {

        if (x == m - 1 && y == n - 1)
            return 1;

        if(visited[x][y] != -1)
            return visited[x][y];

        visited[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && arr[x][y] > arr[nextX][nextY]) {
                visited[x][y] += dfs(nextX,nextY);

            }

        }

        return visited[x][y];
    }
}