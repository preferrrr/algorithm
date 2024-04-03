class Solution {
    public int[] solution(int brown, int yellow) {       
        
        int sum = brown + yellow;
        int row = 3, col = 3;
        
        
        //테두리 격자 개수 : 2i + 2(j-2) 
        for (int i = 3; i <= sum ; i++) {
            int j = sum / i;
            
            if (i * j != sum)
                continue;
            
            else if(2 * i + 2 * (j-2) == brown) {
                row = i;
                col = j;
                break;
            }
        }
        
        int[] answer = {col, row};
        return answer;
    }
}