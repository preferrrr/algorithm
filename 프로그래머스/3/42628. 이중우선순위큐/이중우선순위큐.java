import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        HashSet<Integer> set = new HashSet<>();
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        

        for(int i = 0 ; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String command = st.nextToken();
            
            if (command.equals("I")) {
                
                int num = Integer.parseInt(st.nextToken());
                
                max.add(num);
                min.add(num);
                
            } else {
                                
                String temp = st.nextToken();
                
                if(temp.equals("1")) {
                    
                    if(set.contains(max.peek())) {
                        while (!max.isEmpty() && set.contains(max.peek())) {
                            max.poll();
                        }
                    }
                    
                    set.add(max.poll());
                                            
                        
    
                } else if (temp.equals("-1")) {
                    
                    if(set.contains(min.peek())) {
                        while (!min.isEmpty() && set.contains(min.peek())) {
                            min.poll();
                        }
                    }
                    
                    set.add(min.poll());
                                            
                }
                
            }
            
            System.out.println("min: " + min);
            System.out.println("max: " + max);
            System.out.println("set: " + set + "\n");
            
        }
        
        System.out.println(set);
        
        int a = 0;
        while (!min.isEmpty()) {
            int poll = min.poll();
            
            if (!set.contains(poll)) {
                a = poll;
                break;
            }
        }
        
        int b = 0;
        while (!max.isEmpty()) {
            int poll = max.poll();
            
            if (!set.contains(poll)) {
                b = poll;
                break;
            }
        }
        
        int[] answer = {b, a};
        
        return answer;
    }
}