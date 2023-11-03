import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];


        float total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int h = 0; h <= 256; h++) {

            int item = b;
            int time = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (arr[i][j] - h > 0) {
                        time += 2 * (arr[i][j] - h);
                        item += arr[i][j] - h;
                    } else if (arr[i][j] - h < 0) {
                        time += h - arr[i][j];
                        item -= h - arr[i][j];
                    }
                }
            }

            if (item < 0)
                continue;

            else {
                if (minTime > time) {
                    minTime = time;
                    height = h;
                }
                else if(minTime == time && height < h)
                    height = h;
            }


        }

        System.out.println(minTime + " " + height);


    }
}