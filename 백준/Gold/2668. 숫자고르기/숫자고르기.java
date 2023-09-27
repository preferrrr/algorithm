import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] arr;
    static boolean[] visited;

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        result.stream().forEach(x -> sb.append(x).append("\n"));

        System.out.print(sb);
    }

    static List<Integer> result = new ArrayList<>();
    static void dfs(int start, int i) {
        if(!visited[arr[start]]) {
            visited[arr[start]] = true;
            dfs(arr[start], i);
            visited[arr[start]] = false;
        }

        if(arr[start] == i)
            result.add(i);
    }
}