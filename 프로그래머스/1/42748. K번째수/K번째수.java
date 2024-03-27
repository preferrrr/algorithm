import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int d = 0 ; d < commands.length; d++) {
            int i = commands[d][0];
            int j = commands[d][1];
            int k = commands[d][2];
            
            int[] temp = new int[j - i + 1];
            
            for(int t = 0; t < j - i + 1; t++) {
                temp[t] = array[i - 1 + t];
            }
            
            Arrays.sort(temp);
            
            answer[d] = temp[k-1];
        }
        return answer;
    }
}