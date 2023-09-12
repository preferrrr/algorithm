import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visit;
    static Map<Integer, ArrayList<Integer>> graph;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            graph.get(temp1).add(temp2);
            graph.get(temp2).add(temp1);
        }

        dfs(0, a, b);

        System.out.println(result);

    }

    static void dfs(int cnt, int start, int end) {

        if(start == end) {
            result = cnt;
            return;
        }

        visit[start] = true;

        List<Integer> list = graph.get(start);

        for(int i = 0 ; i < list.size(); i++) {
            if(!visit[list.get(i)]) {
                dfs(cnt+1, list.get(i), end);
            }
        }

    }

}