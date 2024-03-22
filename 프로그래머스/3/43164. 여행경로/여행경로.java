import java.util.*;

class Solution {
    
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static HashMap<String, HashMap<String, Integer>> visited = new HashMap<>();
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        input(tickets);
        
        answer = new String[tickets.length + 1];
        
        dfs("ICN", 0, tickets.length );
        
        return answer;
    }
    
    public void input(String[][] arr) {
                
        for (int i = 0 ; i < arr.length; i++) {
            String a = arr[i][0];
            String b = arr[i][1];
            
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
                visited.put(a, new HashMap<>());
            }
            
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
                visited.put(b, new HashMap<>());
            }
            
            map.get(a).add(b);
        }
        
        for (int i = 0 ; i < arr.length; i++) {
            String a = arr[i][0];
            String b = arr[i][1];
            
            if (!visited.get(a).containsKey(b))
                visited.get(a).put(b, 1);
            else {
                visited.get(a).put(b, visited.get(a).get(b) + 1);
            }
        }
        
        
        
        
    }
    
    static boolean result = false;
    
    public void dfs(String cur, int depth, int goal) {
               
        if (!result)
            answer[depth] = cur;
        
        if (depth == goal && !result) {
            result = true;
            return;
        }
            
        
        
        ArrayList<String> list = map.get(cur);
        
        Collections.sort(list);
        
        
        for(int i = 0 ; i < list.size(); i++) {
            String next = list.get(i);
            
            if (visited.get(cur).get(next) > 0) {
                
                visited.get(cur).put(next, visited.get(cur).get(next) - 1);
                dfs(next, depth + 1, goal);
                visited.get(cur).put(next, visited.get(cur).get(next) + 1);
                
            }
        }
        
    }
    
}