import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String temp = br.readLine();

            StringTokenizer st = new StringTokenizer(temp);


            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        result++;
                        dfs(arr, i, j, w, h);
                    }
                }
            }

            sb.append(result + "\n");


        }

        System.out.print(sb);

    }

    static int dx[] = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    static void dfs(int[][] arr, int i, int j, int w, int h) {
        arr[i][j] = 2;

        for (int d = 0; d < 8; d++) {
            int tempX = i + dx[d];
            int tempY = j + dy[d];

            if (tempX >= 0 && tempY >= 0 && tempX <h && tempY < w && arr[tempX][tempY] == 1)
                dfs(arr, tempX, tempY, w, h);

        }
    }
}