import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0 ; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while (true) {
            
            int poll = queue.peek();
            
            if (poll >= K) 
                break;
            else if(poll < K && queue.size() <= 1) {
                answer = -1;
                break;
            } else {
                queue.poll();
                int second = queue.poll();
                
                queue.add(poll + 2 * second);
                
                answer++;
            } 
            
        }
        
        return answer;
    }
}