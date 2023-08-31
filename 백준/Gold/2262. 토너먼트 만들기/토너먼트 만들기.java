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
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        while(list.size() > 1) {
            int maxIdx = findMax(list);
            if(maxIdx == 0) {
                result += list.get(maxIdx) - list.get(1);
            } else if(maxIdx == list.size() - 1) {
                result += list.get(maxIdx) - list.get(maxIdx - 1);
            } else {
                if(list.get(maxIdx - 1) > list.get(maxIdx + 1))
                    result += list.get(maxIdx) - list.get(maxIdx - 1);
                else
                    result += list.get(maxIdx) - list.get(maxIdx + 1);
            }

            list.remove(maxIdx);

        }


        System.out.println(result);


    }

    static int findMax(List<Integer> list) {
        int maxIdx = 0;

        for(int i = 1 ; i < list.size(); i++) {
            if(list.get(maxIdx) < list.get(i))
                maxIdx = i;
        }

        return maxIdx;
    }
}