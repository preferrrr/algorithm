import java.util.*;

class Solution {
    
    static int[] dif;
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (right + left) / 2;
            
            int count = removeRock(rocks, mid, distance);
            System.out.println("count: " + count);
            if(count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

    public int removeRock(int[] arr, int min, int dis) {
        
        int count = 0;
        int cur = 0;
        
        for(int i = 0 ; i < arr.length; i++) {
            
            if(arr[i] - cur < min) {
                count++;
            } else 
                cur = arr[i];
        }
        
        if (dis - cur < min)
            count++;
        
        return count;
        
        
    }
    
    
    
}