import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int[] sub;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        sub = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            sub[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(sub);
    }

    static int solve() {
        int result = 0;

        for (int i = 0; i < n - k ; i++) {
            result += sub[i];
        }

        return result;
    }
}