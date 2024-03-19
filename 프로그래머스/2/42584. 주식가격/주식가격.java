import java.util.*;

class Solution {
    
    //1 2 3 4 5 4 3 2 1
    //1 2 3 4 5 6
    //0 1 2 3 4 5
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        
        Stack<Integer> stack = new Stack();
        
        for (int i = 0 ; i < size; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        
        return answer;
    }

}