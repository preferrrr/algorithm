import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        long left = 0;
        long right = 0;
        int[] arr = new int[k];
        for (int i = 0 ; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > right)
                right = arr[i];
        }

        right++;

        Arrays.sort(arr);

        while (left < right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0 ; i < k; i++) {
                count += arr[i] / mid;

                if (count >= n)
                    break;
            }

            if (count < n)
                right = mid;
            else
                left = mid + 1;


        }

        System.out.println(left - 1);


    }
}