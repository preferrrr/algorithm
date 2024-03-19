import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        
        Deque<Integer> queue = new ArrayDeque();
        queue.add(arr[0]);
        
        for(int i = 1 ; i < arr.length; i++) {
            if (queue.peekLast() != arr[i])    
                queue.addLast(arr[i]);    
        }
        
        int size = queue.size();
        
        answer = new int[size];
                
        for(int i = 0 ; i < size; i++) {
            answer[i] = queue.pollFirst();
        }

        return answer;
    }
}