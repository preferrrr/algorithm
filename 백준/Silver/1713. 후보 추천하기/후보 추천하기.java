import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Node> list = new ArrayList<>();

        for (int i = 0 ; i < m; i++) {

            //리스트에 있으면 추천++

            //리스트에 없어
            // 리스트의 크기가 3보다 작으면 리스트에 추가
            //리스트의 크기가 3 이상이면 추천 수 제일 작은거 지우기.
            //여러개이면 오래된거부터.
            boolean find = false;
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).num == arr[i]) {
                    list.get(j).count++;
                    find = true;
                    break;
                }
            }


            if(!find) {
                if(list.size() < n) {
                    list.add(new Node(arr[i], 1));
                }
                else {
                    int min = list.get(0).count;
                    int minIdx = 0;

                    for(int k = 1; k < list.size(); k++) {
                        if(list.get(k).count < min) {
                            min = list.get(k).count;
                            minIdx = k;
                        }
                    }

                    list.remove(minIdx);
                    list.add(new Node(arr[i], 1));
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < list.size(); i++) {
            sb.append(list.get(i).num + " ");
        }

        System.out.println(sb);

    }

    static class Node implements Comparable<Node> {
        int num, count;
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }
}