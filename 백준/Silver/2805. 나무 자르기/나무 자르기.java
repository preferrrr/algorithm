import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
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
        for(int i = 0 ; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

    static long solve(int m) {
        Arrays.sort(trees);
        //10 15 17 20
        long l = 0;
        long r = trees[trees.length - 1];

        long result = 0;
        long max = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            long temp = 0;
            for (int i = trees.length - 1; i >= 0; i--) {
                if (trees[i] > mid)
                    temp += trees[i] - mid;
            }

            if (temp < m) {
                r = mid - 1;
            } else {
                if (max > 0 && temp > max)
                    return result;
                l = mid + 1;
                result = mid;
                max = temp;
            }
        }

        return result;
    }

}