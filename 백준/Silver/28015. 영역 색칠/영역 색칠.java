import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            int status = 0;
            for (int j = 0; j < m; j++) {
                if(status == 0 && arr[i][j] != 0) {
                    status = arr[i][j];
                    result++;
                } else if(arr[i][j] == 0) {
                    status = 0;
                } else if(status != arr[i][j] && arr[i][j-1] != arr[i][j]) {
                    result++;
                }
            }

        }

        System.out.println(result);
    }
}