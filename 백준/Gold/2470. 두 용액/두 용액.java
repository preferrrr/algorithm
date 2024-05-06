import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

    }

    static void solve() {
        // -99 -2 -1
        // 4 98

        int temp = arr[0] + arr[1];
        int result1 = arr[0];
        int result2 = arr[1];

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n;

            while (left < right) {
                int mid = (left + right) / 2;
                
                if (mid == i) {
                    left++;
                    continue;
                }

                int sum = arr[i] + arr[mid];

                if (Math.abs(temp) > Math.abs(sum)) {
                    temp = sum;
                    result1 = arr[i];
                    result2 = arr[mid];
                }

                if (sum < 0)
                    left = mid + 1;
                else
                    right = mid;

            }
        }

        if (result1 > result2) {
            System.out.println(result2 + " " + result1);
        } else {
            System.out.println(result1 + " " + result2);
        }

    }
}