import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int size = friends.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < size; i++) {
            map.put(friends[i], i);
        }
        
        int[][] arr1 = new int[size][size];
        int[][] arr2 = new int[size][3];
        
        for(int i = 0 ; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String a = st.nextToken();
            String b = st.nextToken();
            arr1[map.get(a)][map.get(b)]++;
            
            arr2[map.get(a)][0]++;
            arr2[map.get(b)][1]++;
        }
        
        
        for(int i = 0 ; i < size; i++) {
            arr2[i][2] = arr2[i][0] - arr2[i][1];
        }
        

        
        return solve(arr1, arr2, size);
    }
    
    static int solve(int[][] arr1, int[][] arr2, int size) {
        int max = 0;
        
        for(int i = 0 ; i < size; i++) {
            int temp = 0;
            
            for(int j = 0 ; j < size; j++) {
                if(i == j)
                    continue;
                else {
                    if(arr1[i][j] > arr1[j][i])
                        temp++;
                    else if(arr1[i][j] == arr1[j][i] && arr2[i][2] > arr2[j][2])
                        temp++;
                }
            }
            
            if(temp > max)
                max = temp;
        }
        
        return max;
        
        
    }
}