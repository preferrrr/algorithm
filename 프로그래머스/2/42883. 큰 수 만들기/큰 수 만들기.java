import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.add(number.charAt(0));
        
        int count = 0;
        for(int i = 1; i< number.length(); i++) {
            while(!deque.isEmpty() && count < k && deque.peekLast() < number.charAt(i)) {
                count++;
                deque.pollLast();
            }
            deque.addLast(number.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty() && sb.length() < number.length() - k) {
            sb.append(deque.pollFirst());
        }
        
        return sb.toString();
        
        
    }
}