import java.util.*;

class Solution {
    
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        toMap(n, computers);
        
        visited = new boolean[n];
        
        for (int i = 0 ; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }
        }
        
        
        return answer;
    }
    
    public void toMap(int n, int[][] computers) {
        for(int i = 0 ; i < n; i++) {
            map.put(i, new ArrayList());
        }
        
        for (int i = 0 ; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (computers[i][j] == 1)
                    map.get(i).add(j);
            }
        }
    }
    
    public void bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visited[n] = true;
        
        while (!queue.isEmpty()) {
            int poll = queue.pollFirst();
            
            ArrayList<Integer> linked = map.get(poll);
            
            for(int i = 0 ; i < linked.size(); i++) {
                int temp = linked.get(i);
                if (!visited[temp]) {
                    queue.add(temp);
                    visited[temp] = true;
                }
            }
        }
    }
}