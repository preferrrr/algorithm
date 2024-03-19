import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        LinkedList<Integer> queue = new LinkedList<>();
        
        for(int i = 0 ; i < bridge_length; i++) {
            queue.add(0);
        }
        
        int time = 0;
        int curW = 0;
        int i = 0;
        
        while (i < truck_weights.length) {
            time++;
            curW -= queue.pollFirst();
            
            if(curW + truck_weights[i] <= weight) {
                queue.addLast(truck_weights[i]);
                curW += truck_weights[i];
                i++;
            } else queue.addLast(0);
            
            
        }
        
        return time + bridge_length;
    }

}