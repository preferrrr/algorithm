import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List<Node> list;
    static boolean[] visited;
    static Map<Integer, ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t; i++) {
            input();
            sb.append(solution()).append("\n");
        }

        System.out.print(sb);
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 2];
        map = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < n + 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n + 1; i++) {
            Node a = list.get(i);
            for (int j = i + 1; j < n + 2; j++) {
                Node b = list.get(j);

                if (dist(a, b)) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }

    }

    static boolean dist(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y) <= 1000;
    }

    static String solution() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(0);
        visited[0] = true;

        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();

            if(poll == n+1)
                return "happy";

            List<Integer> list = map.get(poll);

            for (int i = 0; i < list.size(); i++) {
                if(!visited[list.get(i)]) {
                    visited[list.get(i)] = true;
                    deque.add(list.get(i));
                }
            }
        }


        return "sad";
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}



