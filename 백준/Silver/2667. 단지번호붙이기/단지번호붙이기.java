import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp.charAt(j) - 48;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    dfs(i, j);
                    result.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int temp : result){
            System.out.println(temp);
        }


    }

    static int[] dx = {-1, 0, 1, 0}; // i
    static int[] dy = {0, 1, 0, -1}; // j
    static int count = 0;
    static void dfs(int i, int j) {
        arr[i][j] = 2;
        count++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < n & y >= 0 && y < n && arr[x][y] == 1) {
                dfs(x, y);
            }
        }

    }
}