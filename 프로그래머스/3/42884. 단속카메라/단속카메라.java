import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for(int i = 0 ; i < routes.length; i++) {
            queue.add(new Node(routes[i][0], routes[i][1]));
        }
        
        int temp = queue.poll().end;
        answer++;
        
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            
            if(temp >= poll.start)
                continue;
            else {
                answer++;
                temp = poll.end;
                System.out.println(temp);
            }
        }
        
        
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int start, end;
    
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o) {
            if(this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}