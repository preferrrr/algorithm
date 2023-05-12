import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visit;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer num = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(num.nextToken(" "));
        int m = Integer.parseInt(num.nextToken(" "));

        num = new StringTokenizer(br.readLine());


        arr = new int[n];
        visit = new boolean[n];
        result = new int[m];

        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(num.nextToken(" "));
        }

        Arrays.sort(arr);

        dfs(n,m,0);
        System.out.println(sb);

    }

    public static void dfs(int n, int m, int depth) {
        if(m == depth) {
            for(int i = 0 ; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(n,m,depth + 1);
                visit[i] = false;
            }
        }
    }
}