import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Flower flower = new Flower();

            int start = Integer.parseInt(st.nextToken())* 100 + Integer.parseInt(st.nextToken());
            int end =  Integer.parseInt(st.nextToken())* 100 + Integer.parseInt(st.nextToken());

            flower.start = start;
            flower.end = end;

            list.add(flower);
        }


        Collections.sort(list);

        int startDay = 301;
        int endDay = 1201;
        int count = 0;
        int max = 0;
        int startIdx = 0;
        boolean isFind = false;

        while (startDay < endDay) {
            isFind = false;
            for (int i = startIdx; i < n; i++) {
                if (list.get(i).start > startDay) {
                    break;
                }
                if (max < list.get(i).end) {
                    max = list.get(i).end;
                    startIdx = i + 1;
                    isFind = true;
                }
            }
            if (isFind) {
                startDay = max;
                count += 1;
            } else {
                break;
            }
        }
        if (max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }


    }
    public static class Flower implements Comparable<Flower> {
        int start;
        int end;

        @Override
        public int compareTo(Flower o) {
            if(this.start == o.start)
                return -this.end + o.end;

            return this.start - o.start;

        }
    }
}