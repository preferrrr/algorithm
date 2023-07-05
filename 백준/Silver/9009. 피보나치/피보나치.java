import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> fib = new ArrayList<>();
            fib.add(0);
            fib.add(1);

            int i = 2;
            while (fib.get(i-1) <= n) {
                fib.add(fib.get(i-1) + fib.get(i-2));
                i++;
            }


            dfs(fib, i - 1, n);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static StringBuilder sb = new StringBuilder();

    public static void dfs(List<Integer> fib, int start, int n) {
        if (start == 0)
            return;
        if (n - fib.get(start) >= 0) {
            dfs(fib, start - 1, n - fib.get(start));
            sb.append(fib.get(start) + " ");
        } else {
            dfs(fib, start - 1, n);
        }


    }
}