import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        int result = 0;

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                result++;
                dfs(map, i);
            }
        }

        System.out.println(result);

    }

    static void dfs(Map<Integer, ArrayList<Integer>> map, int start) {
        visited[start] = true;

        List<Integer> list = map.get(start);

        for(int i = 0 ; i < list.size(); i++) {
            if(!visited[list.get(i)])
                dfs(map, list.get(i));
        }
    }
}