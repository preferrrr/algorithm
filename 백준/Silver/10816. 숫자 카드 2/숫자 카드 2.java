import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (map.containsKey(a))
                map.replace(a, map.get(a) + 1);
            else
                map.put(a, 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(map.containsKey(a))
                sb.append(map.get(a)).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);

    }
}