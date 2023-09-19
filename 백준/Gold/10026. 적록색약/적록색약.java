import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char temp = line.charAt(j);
                if (temp == 'R')
                    arr[i][j] = 1;
                else if (temp == 'G')
                    arr[i][j] = 2;
                else arr[i][j] = 3;
            }
        }

        int count1 = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count1++;
                    dfs(i,j);
                }
            }
        }

        visited = new boolean[n][n];

        int count2 = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count2++;
                    dfs2(i,j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);

    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int tempX = i + dx[d];
            int tempY = j + dy[d];

            if(tempX >= 0 && tempY >= 0 && tempX < n && tempY < n && !visited[tempX][tempY] && arr[i][j] == arr[tempX][tempY]) {
                dfs(tempX, tempY);
            }
        }

    }

    static void dfs2(int i, int j) {
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int tempX = i + dx[d];
            int tempY = j + dy[d];

            if(tempX >= 0 && tempY >= 0 && tempX < n && tempY < n && !visited[tempX][tempY]) {
                if(arr[i][j] == arr[tempX][tempY] || (arr[i][j] == 1 && arr[tempX][tempY] == 2) || (arr[i][j] == 2 && arr[tempX][tempY] == 1))
                    dfs2(tempX, tempY);
            }
        }
    }
}