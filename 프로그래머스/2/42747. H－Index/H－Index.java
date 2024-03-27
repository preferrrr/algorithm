import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int length = citations.length;
        
        //0 1 3 5 6
        
        for (int i = 0 ; i < length; i++) {
            int temp = length - i; 
            
            if (citations[i] >= temp) {
                answer = temp;
                break;
            }
        }
        
        
        return answer;
    }
    
    
}