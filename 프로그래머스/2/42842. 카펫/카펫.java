class Solution {
    public int[] solution(int brown, int yellow) {       
        int sum = brown + yellow;
        
        int row = -1, col = -1;
        
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            
            if (sum % i == 0 && j >= 3) {
                int a = Math.max(i, j);
                int b = Math.min(i, j);
                int c = (a - 2) * (b - 2);
                
                if (c == yellow) {
                    row = a;
                    col = b;
                    break;
                }
            }
        }
    
        int[] answer = {row, col};
        return answer;
    }
}