import java.util.*;

class Solution {
    
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        input(n, edge);
        bfs();
        return getMax();
        
    }
    
    public int getMax() {
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0)
                return count[i];
        }
        
        return 0;
    }
    
    public void bfs() {
        Deque<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(1, 0));
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            
            Node poll = queue.pollFirst();
            count[poll.w]++;
            
            ArrayList<Integer> list = map.get(poll.n);
            
            for(int i = 0 ; i < list.size(); i++) {
                int linked = list.get(i);
                if (!visited[linked]) {
                    queue.add(new Node(linked, poll.w + 1));
                    visited[linked] = true;
                }
            }
        }
    }
    
    
    public void input(int n, int[][] arr) {
        
        visited = new boolean[n + 1];
        count = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int i = 0 ; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
    }
    
    class Node {
        int n, w;
        
        public Node (int n, int w) {
            this.n = n;
            this.w = w;
        }
    }
}