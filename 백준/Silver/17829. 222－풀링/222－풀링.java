import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] temp = arr;
        while (n > 1) {
            int[][] arr2 = new int[n / 2][n / 2];

            for (int i = 0; i < n; i += 2) {

                for (int j = 0; j < n; j += 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(temp[i][j]);
                    list.add(temp[i][j + 1]);
                    list.add(temp[i + 1][j]);
                    list.add(temp[i + 1][j + 1]);

                    Collections.sort(list);

                    arr2[i/2][j/2] = list.get(2);

                }
            }
            n /= 2;

            temp = arr2;
        }

        System.out.println(temp[0][0]);
    }
}