import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, depth;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        depth = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            Arrays.fill(depth[i], -1);
        }
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                if(depth[i][j] == -1)
                    dfs(i, j);
            }
        }

        int result = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                if(depth[i][j] > result)
                    result = depth[i][j];
            }
        }

        System.out.println(result);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int dfs(int i, int j) {

        visited[i][j] = true;
        depth[i][j] = 1;

        for(int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];

            if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y] && arr[x][y] > arr[i][j]) {
                if(depth[x][y] == -1)
                    depth[i][j] = Math.max(depth[i][j], dfs(x, y) + 1);
                else {
                    depth[i][j] = Math.max(depth[i][j], depth[x][y] + 1);
                }
            }
        }

        visited[i][j] = false;


        return depth[i][j];


    }
}