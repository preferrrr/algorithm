import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue();
        int length = progresses.length;
        
        
        while(check(progresses, length)) {
            
            for(int i = 0 ; i < length; i++) { //반복문 한 번 다 도는게 1타임
                
                if (progresses[i] < 100) {
                    if(progresses[i] + speeds[i] < 100)
                        progresses[i] += speeds[i];
                    else {
                        progresses[i] = 100;
                        queue.add(i);
                    }
                }
                
            }
            
            int count = 0;
            
            while (!queue.isEmpty()) {
                int temp = queue.peek();
                if (!check(progresses, temp)) {
                    count++;
                    queue.poll();
                } else break;
            }
            
            if(count != 0)
                result.add(count);
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0 ; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    public boolean check(int[] arr, int l) {
        for(int i = 0 ; i < l; i++) {
            if(arr[i] != 100)
                return true;
        }
        
        return false;
    }

    
    
}