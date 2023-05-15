import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken(" "));

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            hashMap.put(i, list);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken(" "));
            int val = Integer.parseInt(st.nextToken(" "));

            hashMap.get(key).add(val);
            hashMap.get(val).add(key);
        }

        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if(!visit[i]) {
                count++;
                dfs(hashMap, i);
            }
        }

        System.out.println(count);
    }

    static boolean[] visit;
    static int count = 0;

    public static void dfs(HashMap<Integer, ArrayList<Integer>> hashMap, int start) {
        for (int i = 0; i < hashMap.get(start).size(); i++) {
            if (!visit[hashMap.get(start).get(i)]) {
                visit[hashMap.get(start).get(i)] = true;
                dfs(hashMap, hashMap.get(start).get(i));
            }
        }
    }

}