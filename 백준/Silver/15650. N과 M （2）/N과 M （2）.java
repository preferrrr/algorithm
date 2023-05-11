import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken(" "));

        dfs(N, M, 1);
    }

    static boolean[] visit = new boolean[9];
    static int[] arr = new int[9];

    public static void dfs(int N, int M, int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = arr[depth - 1] + 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i ;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }


    }
}