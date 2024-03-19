import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        LinkedList<Node> queue = new LinkedList();
        
        for(int i = 0 ; i < priorities.length; i++) {
            Node node = new Node(i, priorities[i]);
            queue.addLast(node);
        }
        
        int j = 0;
    
        while (true) {
            Node poll = queue.pollFirst();
            
            if(!check(queue, poll.p)) {
                queue.addLast(poll);
                continue;
            }
            
            j++;
            
            if(poll.n == location) {
                answer = j;
                break;
            }
            

        
            
            
            for(int i = 0 ; i < queue.size(); i++) {
                System.out.print(queue.get(i).n + " ");
            }
            System.out.println();
        }
        

        
        return answer;
    }
    
   static class Node implements Comparable<Node> {
        int n, p;
        
        public Node(int n, int p) {
            this.n = n;
            this.p = p;
        }
        
        @Override
        public int compareTo(Node o) {
            if(o.p == this.p)
                return o.n - this.n;
            return o.p - this.p;
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