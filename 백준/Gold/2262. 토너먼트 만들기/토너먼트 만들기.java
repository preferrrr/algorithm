import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        while (list.size() > 1) {

            int min = 0;
            int minIdx = 0;

            for (int i = 1; i < list.size(); i++) {
                if(list.get(minIdx) < list.get(i)) {
                    min = list.get(i);
                    minIdx = i;
                }
            }

            if(minIdx == list.size()-1) {
                result += Math.abs(list.get(minIdx) - list.get(minIdx - 1));
                if(list.get(minIdx) > list.get(minIdx - 1))
                    list.remove(minIdx);
                else list.remove(minIdx - 1);
            }
            else if(minIdx == 0) {
                result += Math.abs(list.get(minIdx) - list.get(minIdx + 1));
                if(list.get(minIdx) > list.get(minIdx + 1))
                    list.remove(minIdx);
                else list.remove(minIdx + 1);
            }

            else if(Math.abs(list.get(minIdx) - list.get(minIdx-1)) > Math.abs(list.get(minIdx) - list.get(minIdx + 1))) {
                result += Math.abs(list.get(minIdx) - list.get(minIdx + 1));
                if(list.get(minIdx) > list.get(minIdx + 1))
                    list.remove(minIdx);
                else list.remove(minIdx + 1);
            } else {
                result += Math.abs(list.get(minIdx) - list.get(minIdx - 1));
                if(list.get(minIdx) > list.get(minIdx - 1))
                    list.remove(minIdx);
                else list.remove(minIdx - 1);
            }

        }

        System.out.println(result);

    }
}