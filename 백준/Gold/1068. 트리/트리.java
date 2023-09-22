import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++) {
            tree.put(i, new ArrayList<>());
        }

        StringTokenizer st= new StringTokenizer(br.readLine());
        int root = -1;
        for(int i = 0 ; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1)
                root = i;
            else {
                tree.get(parent).add(i);
            }
        }

        int delete = Integer.parseInt(br.readLine());

        int result;

        if (root == delete)
            result = 0;
        else {
            result = bfs(root, delete);
        }

        System.out.println(result);

    }

    static int bfs(int root, int delete) {
        int leaf = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()) {

            int poll = deque.pollFirst();

            List<Integer> list = tree.get(poll);
            //리스트의 크기가 0이면 리프 노드,
            //delete할 노드가 부모의 유일한 자식이면, 부모는 리프 노드가 됨.

            if(list.size() == 0)
                leaf++;
            else {
                for(int i = 0 ; i < list.size(); i++) {
                    int child = list.get(i);
                    if(child == delete) {
                        if(list.size() == 1)
                            leaf++;
                        else continue;
                    } else {
                        deque.add(child);
                    }

                }
            }


        }

        return leaf;
    }
}