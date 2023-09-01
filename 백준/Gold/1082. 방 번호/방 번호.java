import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.num = i;
            node.price = Integer.parseInt(st.nextToken());
            list.add(node);
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());

        //자릿수가 커야함.
        //가장 큰 자릿수 구하고

        //0이 아닌 가장 싼거 먼저 골라.
        //그 다음 가장 싼거로 다 채워 => 최대 자릿수
        //하나씩 바꿔

        List<Node> result = new ArrayList<>();

        if (list.get(0).num == 0 && list.size() > 1 && m >= list.get(1).price) {

            m -= list.get(1).price;

            Node node = new Node();
            node.num = list.get(1).num;
            node.price = list.get(1).price;

            result.add(node);
        }//가장 싼게 0이면 그 다음으로 싼거 하나 넣음.



        while (m - list.get(0).price >= 0) {
            Node cheaper = new Node();
            cheaper.price = list.get(0).price;
            cheaper.num = list.get(0).num;
            m -= cheaper.price;
            result.add(cheaper);
        }//최대 자릿수 만듬.

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.num - o1.num;
            }
        }); // 리스트를 숫자가 큰 순으로 다시 정렬.


        boolean zeroCheck = false;
        for (int i = 0 ; i < result.size(); i++) {
            if(result.get(i).num != 0)
                zeroCheck = true;
        }

        if(!zeroCheck) {
            System.out.println(0);
            System.exit(0);
        }


        for (int i = 0; i < result.size(); i++) {

            for (int j = 0; j < list.size(); j++) {

                if (result.get(i).num < list.get(j).num && m >= list.get(j).price - result.get(i).price) {

                    m -= list.get(j).price - result.get(i).price;

                    //result의 num을 list의 num으로 바꿔줘야함.
                    result.get(i).num = list.get(j).num;
                    result.get(i).price = list.get(j).price;

                    break;
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.num - o1.num;
            }
        });

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).num);
        }


    }

    static class Node implements Comparable<Node> {
        int num;
        int price;

        @Override
        public int compareTo(Node o) {
            if (this.price == o.price)
                return o.num - this.num;
            return this.price - o.price;
        }
    }
}