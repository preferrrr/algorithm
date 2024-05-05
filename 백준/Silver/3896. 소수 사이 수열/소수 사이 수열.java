import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < t; i++) {
            sb.append(solve(Integer.parseInt(br.readLine()))).append("\n");
        }

        System.out.print(sb);

    }

    static int solve(int k) {

        if (isPrimeNumber(k))
            return 0;
        else {
            int left = getLeft(k);
            int right = getRight(k);

            return right - left;
        }

    }

    static boolean isPrimeNumber(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0)
                return false;
        }

        return true;
    }

    static int getLeft(int k) {
        for (int i = k - 1; i >= 0; i--) {

            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return i;
        }

        return 0;
    }

    static int getRight(int k) {

        for (int i = k + 1; i <= 1299709; i++) {

            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return i;
        }

        return 0;
    }
}