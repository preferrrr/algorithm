import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[] arr;
    static boolean[] visited, done;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            for(int i = 1; i <= n; i++) {
                if (!visited[i])
                    dfs(i);
            }

            sb.append(n - result).append("\n");




        }

        System.out.print(sb);
    }

    //1 3 3 3
    static void dfs(int cur) {

        visited[cur] = true;

        int next = arr[cur];

        if(!visited[next]) {
            dfs(next);
        } else if(visited[next] && !done[next]) {
            result++;
            while(cur != next) {
                result++;
                next = arr[next];

            }
        }

        done[cur] = true;

    }
}