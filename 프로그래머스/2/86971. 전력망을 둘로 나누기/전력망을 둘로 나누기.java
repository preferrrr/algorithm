import java.util.*;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = solve(wires, n);
        
        return answer;
    }
    
    Map<Integer, ArrayList<Integer>> input(int[][] arr, int n, int flag) {
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int i = 0 ; i < arr.length; i++) {
            if (i != flag) {
                int a = arr[i][0];
                int b = arr[i][1];

                map.get(a).add(b);
                map.get(b).add(a);    
            }
            
        }
        
        return map;
        
    }
    
    int solve(int[][] arr, int n) {
        int min = n;
        
        for (int i = 0 ; i < arr.length; i++) {
            Map<Integer, ArrayList<Integer>> map = input(arr, n, i);
            boolean[] visit = new boolean[n + 1];
            
            int network1 = bfs(map, visit);
            
            int network2 = n - network1;
            
            int dif = Math.abs(network1 - network2);
            
            if (dif < min)
                min = dif;
            
        }
        
        return min;
    }


    int bfs(Map<Integer, ArrayList<Integer>> map, boolean[] visit) {
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.add(1);
        visit[1] = true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.pollFirst();
            count++;
            
            ArrayList<Integer> linked = map.get(poll);
            
            for (int i = 0 ; i < linked.size(); i++) {
                int temp = linked.get(i);
                if (!visit[temp]) {
                    visit[temp] = true;
                    queue.add(temp);
                }
            }
        }
        
        return count;
    }
}