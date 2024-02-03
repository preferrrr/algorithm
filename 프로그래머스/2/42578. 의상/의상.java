import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        Map<String, List<String>> map = new HashMap<>();
        List<String> kind = new ArrayList<>();
        
        for(int i = 0 ; i < clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])) {
                
                List<String> temp = new ArrayList<>();
                temp.add(clothes[i][0]);
                
                map.put(clothes[i][1], temp);
                
                kind.add(clothes[i][1]);

            } else {
                map.get(clothes[i][1]).add(clothes[i][0]);
            }
        }
        
        for(int i = 0 ; i < kind.size(); i++) {
            answer *= map.get(kind.get(i)).size() + 1;

        }
        

        
        return answer - 1;
    }
    
}