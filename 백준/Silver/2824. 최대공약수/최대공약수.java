import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int A = 1;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            A *= a[i];
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        int B = 1;
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            B *= b[i];
        }
        //20 : 1 2 4 5 10 20
        //40 : 1 2 4 5 8 10 20 40 // 4 10
        //90 : 1 2 3 5 6 9 10 15 18 30 45 90 //2 3 15
        //30 : 1 2 3 5 6 10 15 30 // 2 3 5
        //28 : 1 2 4 7 14 28 // 4 7
        //21 : 1 3 7 21 // 3 7

        boolean veryLong = false;
        long result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                long gcd = gcd(a[i], b[j]);
                result *= gcd;

                if (result >= 1000000000) {
                    veryLong = true;
                    result %= 1000000000;
                }

                a[i] /= gcd;
                b[j] /= gcd;

            }
        }


        if (veryLong) {
            String temp = String.valueOf(result);
            StringBuilder sb = new StringBuilder(temp);
            while (sb.length() < 9) {
                sb.insert(0, "0");
            }
            System.out.println(sb);
        } else
            System.out.println(result);


    }

    // 유클리드 호제법 O(log N)
    static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}