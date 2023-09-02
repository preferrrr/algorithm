import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Flower> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Flower flower = new Flower();

            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());

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

                if (list.get(i).start > startDay)// 현재 꽃의 지는 일보다 늦게 피는 꽃이면 break;
                    break;

                if (max < list.get(i).end) { // 현재 꽃의 지는 일보다 빨리 피는 꽃 중,
                    max = list.get(i).end;   // 가장 늦게 지는 꽃 찾기.
                    startIdx = i + 1;
                    isFind = true;
                }
            }

            if(isFind) { // 연결되도록 하는 꽃이 있음.
                startDay = max;
                count += 1;
            } else // 끝까지 다 돌았지만 연결되도록 하는 꽃이 없음.
                break;

        }

        if(max < endDay) // 가장 늦게 지는 꽃의 지는 일이 1130보다 빠름.
            System.out.println(0);
        else System.out.println(count);



    }

    static class Flower implements Comparable<Flower> {
        int start, end;

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start)
                return o.end - this.end;
            return this.start - o.start;
        }
    }
}