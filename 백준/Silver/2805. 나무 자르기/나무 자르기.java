import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long max = 0;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(m));
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max)
                max = trees[i];
        }


    }

    static long solve(int m) {


        long left = 1;
        long right = max;

        while (left < right) {
            long mid = (left + right) / 2;

            long totalLength = 0;
            for (int i = 0 ; i < trees.length; i++) {
                if (trees[i] > mid)
                    totalLength += trees[i] - mid;
            }

            if (totalLength >= m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

}