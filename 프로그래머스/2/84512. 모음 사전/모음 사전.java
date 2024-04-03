import java.util.*;

class Solution {
    
    static String[] alp = {"A", "E", "I", "O", "U"};
    static int count = -1;
    static int result = -1;
    
    public int solution(String word) {

        dfs(new StringBuilder(), word);
        
        return result;
    }
    
    
    
    public void dfs(StringBuilder sb, String word) {
        count++;
        
        if (sb.toString().equals(word)) {
            result = count;
            return;
        } 
        
        if (sb.length() == 5)
            return;
        
        for (int i = 0; i < 5; i++) {
            sb.append(alp[i]);
            dfs(sb, word);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}