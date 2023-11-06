import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int weight = 0;
        int index = 0;

        int count = 0;
        while (count < n) {

            //한 타임
            //다리에 올라가기
            //이동
            //내려가기

            time++;
            for (int i = 0; i < n; i++) {
                if (arr[i][1] == w) {
                    weight -= arr[i][0];
                    count++;
                    arr[i][1]++;
                } else if (arr[i][1] !=0) {
                    arr[i][1]++;
                } else if (arr[i][1] > w) {
                    continue;
                } else
                    break;
            }
            if (index < n && weight + arr[index][0] <= l) {
                arr[index][1]++;
                weight += arr[index][0];
                index++;
            }

        }

        System.out.println(time);


    }

    static class Node {
        int i, state;

        public Node(int i, int state) {
            this.i = i;
            this.state = state;
        }
    }
}