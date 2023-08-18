import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        Collections.sort(list);

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) <= max + 1)
                max += list.get(i);
            else {
                break;
            }
        }

        System.out.println(max + 1);

    }
}