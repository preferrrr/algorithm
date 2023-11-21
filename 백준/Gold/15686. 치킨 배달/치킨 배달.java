import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n, m;
    static int result = Integer.MAX_VALUE;
    static List<Node> homes = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();

    static boolean[] visited;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1)
                    homes.add(new Node(i, j));
                else if (arr[i][j] == 2)
                    chickens.add(new Node(i, j));
            }
        }
        visited = new boolean[chickens.size()];

        solve(0, 0);

        System.out.println(result);


    }

    static void dis() {

        int totalDis = 0;
        for (int i = 0; i < homes.size(); i++) {

            Node home = homes.get(i);

            int dis = 100;

            for (int j = 0; j < chickens.size(); j++) {
                if(visited[j]) {
                    Node chicken = chickens.get(j);
                    int temp = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
                    if (temp < dis)
                        dis = temp;
                }

            }

            totalDis += dis;
        }

        if(result > totalDis)
            result = totalDis;
    }


    static void solve(int x, int count) {

        if (count == m) {
            dis();
            return;
        }

        for (int i = x; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

}