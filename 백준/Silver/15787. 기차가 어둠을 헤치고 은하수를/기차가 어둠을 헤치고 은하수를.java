import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n + 1][21];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(arr[i], 'x');
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[b][c] = 'o';
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[b][c] = 'x';

            } else if (a == 3) {
                int b = Integer.parseInt(st.nextToken());

                for (int j = 20; j >= 1; j--) {
                    arr[b][j] = arr[b][j - 1];
                    arr[b][j-1] = 'x';
                }


            } else {
                int b = Integer.parseInt(st.nextToken());

                for(int j = 1; j <= 19; j++) {
                    arr[b][j] = arr[b][j+1];
                    arr[b][j+1] = 'x';
                }


            }
        }

        int count = 0;
        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= 20; j++) {
                sb.append(arr[i][j]);
            }
            String train = sb.toString();

            if(set.contains(train))
                continue;
            else {
                set.add(train);
                count++;
            }
        }

        System.out.println(count);

    }
}