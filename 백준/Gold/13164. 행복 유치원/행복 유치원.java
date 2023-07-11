import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sub = new int[n-1];
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sub[i - 1] = arr[i] - arr[i - 1];
        }

        Arrays.sort(sub);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += sub[i];
        }

        System.out.println(result);

    }
}