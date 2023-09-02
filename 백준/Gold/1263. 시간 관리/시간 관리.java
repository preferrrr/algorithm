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

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int workTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            Node node = new Node();
            node.workTime = workTime;
            node.endTime = endTime;

            list.add(node);
        }

        Collections.sort(list);

        int time = list.get(0).endTime - list.get(0).workTime;

        for(int i = 1; i < n; i++) {
            if(time <= list.get(i).endTime) {
                time -= list.get(i).workTime;
            } else {
                time = list.get(i).endTime - list.get(i).workTime;
            }
        }

        if(time < 0)
            System.out.println(-1);
        else
            System.out.println(time);



    }

    static class Node implements Comparable<Node> {
        int workTime;
        int endTime;


        @Override
        public int compareTo(Node o) {
            if(this.endTime == o.endTime)
                return o.workTime  - this.workTime;
            return o.endTime - this.endTime;
        }
    }
}