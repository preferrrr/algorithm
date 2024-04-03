import java.util.*;

class Solution {
    
    static int count = 0;
    static char[] arr;
    static boolean[] visit;
    static HashSet<Integer> set = new HashSet();
    
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        visit = new boolean[arr.length];
        dfs(0, new StringBuilder());
        return count;
    }
    
    public void dfs(int cur, StringBuilder sb) {
    
        if (cur == arr.length)
            return;


        
        for (int i = 0 ; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sb.append(arr[i]);
                
                check(sb);
                dfs(cur + 1, sb);
                
                visit[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }            
        }
        
    }
    
    public void check(StringBuilder sb) {
        
        int n = Integer.parseInt(sb.toString());
        
        if (set.contains(n) || n <= 1) {
            return;
        }
        
        set.add(n);
        
        boolean result = true;
        
        for (int i = 2 ; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        
        if (result)
            count++;
        
        return;
    }
}