import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n;
    static int m;
    static boolean[] visit;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        visit = new boolean[n];
        arr = new int[n];

        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken(" "));
        }

        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb);

    }

    public static void dfs(int prev, int depth) {
        if(depth == m) {
            for(int i = 0 ; i < m; i++) {
                sb.append(result[i]+ " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = prev ; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
}