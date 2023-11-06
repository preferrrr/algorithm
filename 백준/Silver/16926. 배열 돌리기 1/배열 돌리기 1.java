import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < r; i++)
            turn();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }

    //arr[0][0] = arr[0][1], arr[0][1] = arr[0][2]...
    //arr[1][0] = arr[0][0], arr[2][0] = arr[1][0]...
    static void turn() {

        int min = Math.min(n, m) / 2;

        for (int t = 0; t < min; t++) {
            int temp = arr[t][t];

            for (int i = t; i < m - t - 1; i++)
                arr[t][i] = arr[t][i + 1];

            for (int i = t; i < n - t - 1; i++)
                arr[i][m - 1 - t] = arr[i + 1][m - 1 - t];

            for (int i = m - t - 1; i > t; i--)
                arr[n - 1 - t][i] = arr[n - 1 - t][i - 1];

            for (int i = n - 1 - t; i > t; i--)
                arr[i][t] = arr[i-1][t];

            arr[t+1][t] = temp;

        }
    }
}