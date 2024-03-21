import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
    
        PriorityQueue<Node> job = new PriorityQueue<>((o1, o2)-> o1.x - o2.x);
        
        for(int i = 0 ; i < jobs.length; i++) {
            job.add(new Node(jobs[i][0], jobs[i][1]));
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.y - o2.y);
                
        int waitTime = 0;
        int curTime = 0;
        int temp = job.peek().x;
        
        int processTime = 0;
        int endTime = 0;
        
        boolean isWorking = false;
        
        
        while (true) {
           
            while (!job.isEmpty() && job.peek().x <= curTime) { //현재 시간에 들어온 요청 있으면 큐에 넣어.
                queue.add(job.poll());
                System.out.println("curTime: " + curTime + ", queue.size: " + queue.size() );
            }
            
            if (isWorking) { //현재 작업 중
                processTime++;
                
                if(processTime == endTime) {
                    processTime = 0;
                    endTime = 0;
                    isWorking = false;
                }
            }
            
            if (!isWorking) { 
                if (!queue.isEmpty()) {
                    Node poll = queue.poll();
                    waitTime += curTime - poll.x;
                    System.out.println("curTime: " +curTime + ", poll.x" + poll.x);
                    endTime = poll.y;
                    isWorking = true;
                } else if(queue.isEmpty() && job.isEmpty())
                    break;
                
                
            }
            
        
            curTime++;

        }
        
                          
        System.out.println("curTime: "+curTime + " , " + waitTime + ", temp : " + temp);
        return (curTime + waitTime - temp) / jobs.length;
    }
    
    public class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x ;
            this.y = y;
        }
    }


}