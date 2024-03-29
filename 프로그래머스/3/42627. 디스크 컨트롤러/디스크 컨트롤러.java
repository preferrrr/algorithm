import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<Node> wait = new PriorityQueue<>((o1, o2) -> o1.requestTime - o2.requestTime); // 큐에서 각 작업은 작업에 걸리는 시간 순으로 정렬됨.
        PriorityQueue<Node> ready = new PriorityQueue<>((o1, o2)-> o1.processingTime - o2.processingTime); //큐에서 각 작업은 시작 시간 순으로 정렬됨.
        
        for(int i = 0 ; i < jobs.length; i++) 
            wait.add(new Node(jobs[i][0], jobs[i][1]));
                
        int waitTime = 0; //총 기다린 시간.
        int curTime = 0; //현재 시간
        
        while (true) {
           
            while (!wait.isEmpty() && wait.peek().requestTime <= curTime) { //현재 시간 이하에 요청된 작업들이 있으면, 작업 대기 큐에 넣음.
                ready.add(wait.poll());
            }
            
            
            if (ready.isEmpty() && !wait.isEmpty()) { //현재 작업 중인게 없고, 처리해야할 작업은 남은 경우
                waitTime -= wait.peek().requestTime - curTime;
                curTime = wait.peek().requestTime;
            } else if (!ready.isEmpty()) { //
                Node poll = ready.poll();
                waitTime += curTime - poll.requestTime;
                
                curTime += poll.processingTime;
            } else if (ready.isEmpty() && wait.isEmpty())
                break;

        }
        
        System.out.println("curTime: " + curTime + ", waitTime: " + waitTime);
                          
        return (curTime + waitTime) / jobs.length;
    }
    
    public class Node {
        int requestTime, processingTime;
        public Node (int requestTime, int processingTime) {
            this.requestTime = requestTime ;
            this.processingTime = processingTime;
        }
    }


}