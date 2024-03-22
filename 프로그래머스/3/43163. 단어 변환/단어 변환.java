import java.util.*;

class Solution {
    
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
     
        visited = new boolean[words.length];
        
        toMap(words);
        
        return bfs(begin, target, words);
        //한개만 다르면 연결되어 있음
        
    }
    
    public void toMap(String[] words) {
        
        for(int i = 0 ; i < words.length; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0 ; i < words.length - 1; i++) {
            
            String a = words[i];
            
            for(int j = i + 1 ; j < words.length; j++) {
                String b = words[j];
                
                int count = 0;
                for(int k = 0; k < a.length(); k++) {
                    if (a.charAt(k) != b.charAt(k))
                        count++;
                }
                
                if (count == 1) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        
    }
    
    public int bfs(String begin, String target, String[] words) {
        
        Deque<Node> queue = startDeque(begin, words);
        
        while (!queue.isEmpty()) {
            
            Node poll = queue.pollFirst();
            
            if (words[poll.i].equals(target))
                return poll.w;
            
            ArrayList<Integer> linked = map.get(poll.i);
            
            for(int i = 0 ; i < linked.size(); i++) {
                
                if (!visited[linked.get(i)]) {
                    queue.add(new Node(linked.get(i), poll.w + 1));
                    visited[linked.get(i)] = true;
                }
            }
        }
        
        return 0;
        
    }
    
    public Deque<Node> startDeque(String begin, String[] words) {
        Deque<Node> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < words.length; i++) {
            
            int count = 0;
            for (int j = 0 ; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j))
                    count++;
            }
            
            if(count == 1) {
                queue.add(new Node(i, 1));
                visited[i] = true;
            }
                
        }
        
        return queue;
    }
    
    public class Node {
        int i, w;
        
        public Node (int i, int w) {
            this.i = i;
            this.w = w;
        }
    }
}