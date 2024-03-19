import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        boolean answer = true;
        
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        
        HashSet<String> set = new HashSet();

        for(int i = 0 ; i < phone_book.length; i++) {
            
            String word = phone_book[i];
            
            
            for(int j = 1 ; j <= word.length(); j++) {
                
                String temp = word.substring(0, j);
                if(set.contains(temp))
                    return false;
            }
            
            set.add(word);

        }
        
        
        
        return answer;
    }
}