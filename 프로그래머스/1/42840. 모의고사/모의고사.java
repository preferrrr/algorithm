import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first  = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third  = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int one = 0, two = 0, three = 0;
        
        for (int i = 0 ; i < answers.length; i++) {
            if (answers[i] == first[i % 5])
                one++;
            if (answers[i] == second[i % 8])
                two++;
            if (answers[i] == third[i % 10])
                three++;
        }
        
        int max = getMax(one, two, three);
        
        List<Integer> list = new ArrayList<>();
        
        if (one == max)
            list.add(1);
        if (two == max)
            list.add(2);
        if (three == max)
            list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}