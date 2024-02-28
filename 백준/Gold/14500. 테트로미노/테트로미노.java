import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int max = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(max);

    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() {
        a();
        b();
        c();
    }

    static void a() {
        int aMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                int temp = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
                if (temp > aMax)
                    aMax = temp;
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n - 3; i++) {
                int temp = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 3][j];
                if (temp > aMax)
                    aMax = temp;
            }
        }

        if (aMax > max)
            max = aMax;

    }

    static void b() {
        int bMax = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                int temp = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1];
                if (temp > bMax)
                    bMax = temp;
            }
        }

        if (bMax > max)
            max = bMax;
    }

    static void c() {
        int cMax = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                c1(i, j);
            }
        }

        for (int i = 0 ; i < n-1; i++) {
            for(int j = 0; j < m-2; j++) {
                c2(i, j);
            }
        }
    }

    static void c1(int i, int j) {
        int c1Max = 0;

        int left = arr[i][j] + arr[i + 1][j] + arr[i + 2][j];
        int right = arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1];

        for (int k = 0; k < 3; k++) {
            c1Max = Math.max(c1Max, left + arr[i + k][j + 1]);
            c1Max = Math.max(c1Max, right + arr[i + k][j]);
        }

        c1Max = Math.max(c1Max, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);
        c1Max = Math.max(c1Max, arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j]);


        if (c1Max > max)
            max = c1Max;
    }

    static void c2(int i, int j) {
        int c2Max = 0;

        int up = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
        int down = arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];

        for (int k = 0; k < 3; k++) {
            c2Max = Math.max(c2Max, up + arr[i + 1][j + k]);
            c2Max = Math.max(c2Max, down + arr[i][j + k]);
        }

        c2Max = Math.max(c2Max, arr[i][j + 1] + arr[i + 1][j + 1] + arr[i][j] + arr[i + 1][j + 2]);
        c2Max = Math.max(c2Max, arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i][j + 2]);

        if (c2Max > max)
            max = c2Max;

    }

}