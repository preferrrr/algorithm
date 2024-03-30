import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Node> queue = new LinkedList(); //실행 대기 큐, 
        
        for(int i = 0 ; i < priorities.length; i++) {
            Node node = new Node(i, priorities[i]);
            queue.addLast(node);
        }
        
    
        while (true) {
            Node poll = queue.pollFirst(); //큐에서 작업을 뽑고, 
            
            if(!check(queue, poll.p)) { //이 작업이 가장 높은 우선순위인지 체크한다.
                queue.addLast(poll);
                continue;
            }
            
            answer++;
            
            if(poll.n == location) { //뽑은 작업이 프로세스의 위치 k와 같으면 반복문을 멈춘다.
                break;
            }
        }
        

        
        return answer;
    }
    
   static class Node {
        int n, p;
        
        public Node(int n, int p) {
            this.n = n;
            this.p = p;
        }
    }
    
    public boolean check(LinkedList<Node> queue, int priority) {
        for(int i = 0 ; i < queue.size(); i++) {
            if(queue.get(i).p > priority)
                return false;
        }
        
        return true;
    }
}