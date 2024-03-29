import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        HashSet<Integer> set = new HashSet<>(); //큐에서 삭제된 값인지 저장하기 위한 HashSet, 시간복잡도를 고려하여 
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder()); //큰 숫자가 높은 우선순위를 가지는 큐
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); //작은 숫자가 높은 우선순위를 가지는 큐
        

        for(int i = 0 ; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String command = st.nextToken();
            
            if (command.equals("I")) { // I이면 큐 둘 다에 추가
                
                int num = Integer.parseInt(st.nextToken());
                
                maxQueue.add(num);
                minQueue.add(num);
                
            } else {
                                
                String temp = st.nextToken();
                
                if(temp.equals("1")) { // 1인 경우 큐에서 최대값을 삭제한다.
                    
                    if(set.contains(maxQueue.peek())) { //최대값이 이미 큐에서 제거된 값이면 
                        while (!maxQueue.isEmpty() && set.contains(maxQueue.peek())) { //삭제되지 않은 값일 때까지 최대값 제거
                            maxQueue.poll();
                        }
                    }
                    
                    set.add(maxQueue.poll()); //최대값 삭제 후, HashSet에 추가하여 삭제 표시 해줌.
                                            
                        
    
                } else if (temp.equals("-1")) { // -1인 경우 큐에서 최소값을 삭제해줌
                    
                    if(set.contains(minQueue.peek())) { //최소 값이 이미 삭제된 값이면
                        while (!minQueue.isEmpty() && set.contains(minQueue.peek())) { //삭제되지 않은 값일 때까지 최소값 제거
                            minQueue.poll();
                        }
                    }
                    
                    set.add(minQueue.poll()); //최소값 삭제 후, HashSet에 추가하여 삭제 표시 해줌
                                            
                }
                
            }
            
        }
                
        int a = 0;
        while (!minQueue.isEmpty()) {
            int poll = minQueue.poll();
            
            if (!set.contains(poll)) {
                a = poll;
                break;
            }
        }
        
        int b = 0;
        while (!maxQueue.isEmpty()) {
            int poll = maxQueue.poll();
            
            if (!set.contains(poll)) {
                b = poll;
                break;
            }
        }
        
        int[] answer = {b, a};
        
        return answer;
    }
}