import java.util.*;

class Solution {
    public int solution(String name) {
        
        int count = 0;
        int min = name.length() - 1;

        for(int i = 0 ; i < name.length(); i++) {
            count += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            
            int temp = i + 1;
            while (temp < name.length() && name.charAt(temp) == 'A')
                temp++;
            
            min = Math.min(min, Math.min((i * 2) + name.length() - temp, (name.length() - temp) * 2 + i));
        }
        
        count += min;
        
        return count;
        
    }
}