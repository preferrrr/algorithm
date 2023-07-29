import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalSum = 0;
        int div2Sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
            div2Sum += arr[i] / 2;
        }

        if(totalSum % 3 != 0) {
            System.out.println("NO");
        } else {
            if(totalSum / 3 <= div2Sum)
                System.out.println("YES");
            else {
                System.out.println("NO");
            }
        }


    }
}