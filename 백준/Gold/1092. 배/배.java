import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        List<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());

        Collections.sort(box, Collections.reverseOrder());


        int result = 0;

        if (crane.get(0) < box.get(0)) {
            result = -1;
        } else {
            while (!box.isEmpty()) {

                int idx = 0;
                for (int i = 0; i < n;) {
                    if(idx == box.size()) break;
                    else if(crane.get(i) >= box.get(idx)) {
                        box.remove(idx);
                        i++;
                    } else {
                        idx++;
                    }

                }
                result++;

            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}