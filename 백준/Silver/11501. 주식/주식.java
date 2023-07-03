import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] price = new int[n];

            for (int j = 0; j < n; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }
            max(price);
        }

        System.out.print(sb);

    }


    public static StringBuilder sb = new StringBuilder();

    public static void max(int[] price) {
        int cost = price[price.length - 1];
        long result = 0;

        for (int i = price.length - 2; i >= 0; i--) {
            if (cost > price[i]) {
                result += cost - price[i];
            } else {
                cost = price[i];
            }

        }

        sb.append(result+"\n");

    }
}